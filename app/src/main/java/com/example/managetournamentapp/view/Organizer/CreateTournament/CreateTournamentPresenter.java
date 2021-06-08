package com.example.managetournamentapp.view.Organizer.CreateTournament;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
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
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CreateTournamentPresenter {
    private CreateTournamentView view;
    private ArrayList<String> sportTypes;
    private ArrayList<String> ageDivisions;
    private ArrayList<String> teamNumbers;
    private Tournament connectedTournament;
    private TournamentDAO tournamentDAO;
    private Organizer organizer;

    public CreateTournamentPresenter() {
        sportTypes = findSportTypes();
        ageDivisions = findAgeDivisions();
        teamNumbers = new ArrayList<>(Arrays.asList(new String[]{"8", "16", "32"}));
    }

    public void showPreviousInfo(String tournamentName) {
        if (tournamentName == null)
            return;
        connectedTournament = tournamentDAO.find(tournamentName);
        if (connectedTournament == null)
            return;

        view.setTournamentTitle(connectedTournament.getTitle());
        view.setDescription(connectedTournament.getDescription());
        view.setLocation(connectedTournament.getLocation());
        view.setStartDate(connectedTournament.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-", "/"));
        view.setFinishDate(connectedTournament.getFinishDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-", "/"));
        view.setAgeDivision(getAgeDivisionIndex(connectedTournament.getAgeDivision().toString()));
        view.setTeamsNumber(getTeamsNumberIndex(String.valueOf(connectedTournament.getMAX_TEAMS_NUMBER())));
        view.setSportType(getSportTypeIndex(connectedTournament.getSportType().getName()));

        view.lockPrevious();
    }

    public void onSaveTournament() {
        String title = view.getTournamentTitle();
        String location = view.getLocation();
        String startDate = view.getStartDate();
        String finishDate = view.getFinishDate();
        String description = view.getDescription();
        String ageDivision = ageDivisions.get(view.getAgeDivision());
        String sportType = sportTypes.get(view.getSportType());
        String teamsNumber = teamNumbers.get(view.getTeamsNumber());


        if (title.length() < 2 || title.length() > 20 || !validateTitle(title))
            view.showPopUp(view, "Title must contain at least 2 alphanumerical chars and be 20 chars long!");
        else if (location.length() < 2 || location.length() > 20 || !validateName(location))
            view.showPopUp(view, "Location must be at least 2 chars and only alphabetical chars!");
        else if (!validateDate(startDate) || !validateDate(finishDate))
            view.showPopUp(view, "Not valid date!");
        else {

            if (connectedTournament == null) {
                if (checkTitle(title, connectedTournament)) {
                    view.showPopUp(view, "Title already in use! Try a new one.");
                    return;
                }
                LocalDate startLocalDate = reformatDate(startDate);
                LocalDate finishLocalDate = reformatDate(finishDate);
                ArrayList<String> basicInfo = new ArrayList<>(Arrays.asList(title, startLocalDate.toString(), finishLocalDate.toString(), location, sportType, teamsNumber, ageDivision, description));
                view.startSetDates(basicInfo);
            } else {
                if (checkTitle(title, connectedTournament)) {
                    view.showPopUp(view, "Title already in use! Try a new one.");
                    return;
                }
                connectedTournament.setTitle(title);
                connectedTournament.setDescription(description);
                connectedTournament.setLocation(location);
                LocalDate startLocalDate = reformatDate(startDate);
                LocalDate finishLocalDate = reformatDate(finishDate);
                connectedTournament.setStartDate(startLocalDate);
                connectedTournament.setFinishDate(finishLocalDate);
                connectedTournament.setAgeDivision(AgeDivision.values()[getAgeDivisionIndex(ageDivision)]);
                connectedTournament.setSportType(new Sport(sportType));
                view.startSaveTournament(organizer.getTitle());
            }
        }
    }

    public void setOrganizer(User user) {
        if (user == null)
            return;
        if (!(user instanceof Organizer))
            return;
        organizer = (Organizer) user;

    }

    public ArrayList<String> getSportTypes() {
        return sportTypes;
    }

    public ArrayList<String> getAgeDivisions() {
        return ageDivisions;
    }

    public ArrayList<String> getTeamNumbers() {
        return teamNumbers;
    }

    private int getSportTypeIndex(String sportType) {
        for (int i = 0; i < sportTypes.size(); i++) {
            if (sportTypes.get(i).equals(sportType))
                return i;
        }
        return 0;
    }

    private int getAgeDivisionIndex(String ageDivision) {
        for (int i = 0; i < ageDivisions.size(); i++) {
            if (ageDivisions.get(i).equals(ageDivision))
                return i;
        }
        return 0;
    }

    private int getTeamsNumberIndex(String teamsNumber) {
        for (int i = 0; i < teamNumbers.size(); i++) {
            if (teamNumbers.get(i).equals(teamsNumber))
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

    private ArrayList<String> findAgeDivisions() {
        ArrayList<String> ageDivisions = new ArrayList<>();
        for (int i = 0; i < AgeDivision.values().length; i++) {
            ageDivisions.add(AgeDivision.values()[i].toString());
        }
        return ageDivisions;
    }


    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public boolean checkTitle(String title, Tournament tournament) {
        return tournamentDAO.TitleIsUsed(title, tournament);
    }

    public void setView(CreateTournamentView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public boolean validateTitle(String name) {
        String valid = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(valid);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean validateName(String name) {
        String valid = "^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(valid);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public LocalDate reformatDate(String date) {
        date = date.replace("/", "-");
        LocalDate Localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        return Localdate;
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

    public void onHomePage() {

        view.backToHomePage(organizer.getTitle());

    }
}
