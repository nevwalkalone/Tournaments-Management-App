package com.example.managetournamentapp.view.Organizer.SetDates;

import android.util.Log;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Round;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.TournamentType;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SetDatesPresenter {
    private SetDatesView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<String> basicInfo;
    private ArrayList<String> sportTypes;
    private ArrayList<String> ageDivisions;
    private int[] gamesPerRound;
    private int teamsNumber;
    private Organizer organizer;

    public SetDatesPresenter() {
        sportTypes = findSportTypes();
        ageDivisions = findAgeDivisions();
    }


    public void findBasicInfo(ArrayList<String> basicInfo) {
        this.basicInfo = basicInfo;
        teamsNumber = Integer.parseInt(basicInfo.get(5));

        if (teamsNumber == 8)
            gamesPerRound = new int[]{12, 2, 1};
        else if (teamsNumber == 16)
            gamesPerRound = new int[]{24, 4, 2, 1};
        else if (teamsNumber == 32)
            gamesPerRound = new int[]{48, 8, 4, 2, 1};

    }

    public void onSaveTournament() {

        ArrayList<String> datesReceived = view.getDates();

        if (teamsNumber == 8) {
            if (datesReceived.size() != 6) {
                view.showPopUp(view, "You didn't set all round dates.");
                return;
            }
        } else if (teamsNumber == 16) {
            if (datesReceived.size() != 8) {
                view.showPopUp(view, "You didn't set all round dates.");
                return;
            }
        } else if (teamsNumber == 32) {
            if (datesReceived.size() != 10) {
                view.showPopUp(view, "You didn't set all round dates.");
                return;
            }
        }

        for (String date : datesReceived)
            if (!validateDate(date)) {
                view.showPopUp(view, "There are invalid dates!");
                return;
            }
        for (int i = 1; i < datesReceived.size(); i++) {
            String prevS = datesReceived.get(i - 1).replace("/", "-");
            String nextS = datesReceived.get(i).replace("/", "-");
            LocalDate prev = LocalDate.parse(prevS, DateTimeFormatter.ofPattern("dd-MM-uuuu"));
            LocalDate next = LocalDate.parse(nextS, DateTimeFormatter.ofPattern("dd-MM-uuuu"));
            if (prev.isAfter(next)) {
                view.showPopUp(view, "Previous round is after next round. Invalid dates.");
                return;
            }

        }

        AgeDivision ageDivision = AgeDivision.values()[getAgeDivisionIndex(basicInfo.get(6))];
        LocalDate startDate = LocalDate.parse(basicInfo.get(1));
        LocalDate finishDate = LocalDate.parse(basicInfo.get(2));
        ArrayList<LocalDate> dates = findGameDates(findRoundDates());

        Tournament tournament = new Tournament(basicInfo.get(0), startDate, finishDate, basicInfo.get(3), new Sport(basicInfo.get(4)), teamsNumber, ageDivision, dates);
        tournament.setDescription((basicInfo.get(7)));
        initEmptyTeams(tournament);

        tournamentDAO.save(tournament);
        organizer.addTournament(tournament);
        view.startSaveTournament(organizer.getTitle());

    }

    private void initEmptyTeams(Tournament tournament) {
        for (Round round : tournament.getRounds()) {
            ArrayList<Team> emptyTeams = new ArrayList<>();
            for (int i = 0; i < round.getTeamsNumber(); i++)
                emptyTeams.add(new Team());
            round.setup(emptyTeams);
        }
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }


    private int getAgeDivisionIndex(String ageDivision) {
        for (int i = 0; i < ageDivisions.size(); i++) {
            if (ageDivisions.get(i).equals(ageDivision))
                return i;
        }
        return 0;
    }

    private ArrayList<String> findSportTypes() {
        ArrayList<String> sportTypes = new ArrayList<>();
        for (int i = 0; i < TournamentType.values().length; i++) {
            sportTypes.add(TournamentType.values()[i].toString());
        }
        return sportTypes;
    }

    public ArrayList<LocalDate> findGameDates(ArrayList<LocalDate> roundDates) {
        ArrayList<LocalDate> gameDates = new ArrayList<>();

        for (int i = 0; i < gamesPerRound.length; i++) {
            LocalDate roundStart = roundDates.get(i);
            LocalDate roundFinish = roundDates.get(i + 1);
            for (int j = 0; j < gamesPerRound[i]; j++)
                gameDates.add(roundStart);
        }
        return gameDates;
    }

    public ArrayList<LocalDate> findRoundDates() {
        ArrayList<LocalDate> roundDates = new ArrayList<>();
        String current;
        for (String stringDate : view.getDates()) {
            current = stringDate.replace("/", "-");
            roundDates.add(LocalDate.parse(current, DateTimeFormatter.ofPattern("dd-MM-uuuu")));
        }
        return roundDates;
    }

    private ArrayList<String> findAgeDivisions() {
        ArrayList<String> ageDivisions = new ArrayList<>();
        for (int i = 0; i < AgeDivision.values().length; i++) {
            ageDivisions.add(AgeDivision.values()[i].toString());
        }
        return ageDivisions;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void setView(SetDatesView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public boolean validateDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public void onHomePage(){
        User user = new MemoryLoggedInUser().getUser();
        if (user instanceof Player){
            view.backToHomePage(true,user.getCredentials().getUsername());
        }
        else{
            view.backToHomePage(false,((Organizer)user).getTitle());
        }
    }
}
