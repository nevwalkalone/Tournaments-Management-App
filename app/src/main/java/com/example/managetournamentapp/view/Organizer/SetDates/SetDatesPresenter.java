package com.example.managetournamentapp.view.Organizer.SetDates;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.TournamentType;

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


    public void findBasicInfo(ArrayList<String> basicInfo){
        this.basicInfo = basicInfo;
        teamsNumber = Integer.parseInt( basicInfo.get(5) );

        if (teamsNumber==8)
            gamesPerRound = new int[]{12, 2, 1};
        else if (teamsNumber==16)
            gamesPerRound = new int[]{24, 4, 2, 1};
        else if (teamsNumber==32)
            gamesPerRound = new int[]{48, 8, 4, 2, 1};

    }

    public void onSaveTournament(){
        if(false){

        }else{
            AgeDivision ageDivision = AgeDivision.values()[getAgeDivisionIndex(basicInfo.get(6))];
            LocalDate startDate = LocalDate.parse(basicInfo.get(1));
            LocalDate finishDate = LocalDate.parse(basicInfo.get(2));
            ArrayList<LocalDate> dates = findGameDates( findRoundDates() );

            Tournament tournament =  new Tournament( basicInfo.get(0), startDate, finishDate ,basicInfo.get(3) , new Sport(basicInfo.get(4)),  teamsNumber , ageDivision, dates );
            tournamentDAO.save( tournament );
            organizer.addTournament( tournament );
            view.startSaveTournament(tournament.getTitle());
        }
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }


    private int getAgeDivisionIndex(String ageDivision){
        for (int i = 0; i< ageDivisions.size(); i++){
            if (ageDivisions.get(i).equals(ageDivision) )
                return i;
        }
        return 0;
    }

    private ArrayList<String> findSportTypes(){
        ArrayList<String> sportTypes = new ArrayList<>();
        for (int i = 0; i< TournamentType.values().length; i++){
            sportTypes.add(TournamentType.values()[i].toString());
        }
        return  sportTypes;
    }

    public ArrayList<LocalDate> findGameDates(ArrayList<LocalDate> roundDates){
        ArrayList<LocalDate> gameDates = new ArrayList<>();

        for (int i=0; i<gamesPerRound.length; i++){
            LocalDate roundStart =  roundDates.get(i);
            LocalDate roundFinish = roundDates.get(i+1);
            for (int j=0;j<gamesPerRound[i];j++)
                gameDates.add(roundStart);
        }
        return gameDates;
    }

    public ArrayList<LocalDate> findRoundDates(){
        ArrayList<LocalDate> roundDates = new ArrayList<>();
        String current;
        for (String stringDate : view.getDates()){
            current = stringDate.replace("/", "-");
            roundDates.add( LocalDate.parse(current, DateTimeFormatter.ofPattern("dd-MM-uuuu")) );
        }
        return roundDates;
    }

    private ArrayList<String> findAgeDivisions(){
        ArrayList<String> ageDivisions = new ArrayList<>();
        for (int i = 0; i< AgeDivision.values().length; i++){
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
}
