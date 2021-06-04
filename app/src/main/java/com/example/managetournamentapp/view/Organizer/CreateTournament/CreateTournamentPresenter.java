package com.example.managetournamentapp.view.Organizer.CreateTournament;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.TournamentType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


public class CreateTournamentPresenter {
    private CreateTournamentView view;
    private ArrayList<String> sportTypes;
    private ArrayList<String> ageDivisions;
    private Tournament connectedTournament;
    private TournamentDAO tournamentDAO;

    public CreateTournamentPresenter() {
        sportTypes = findSportTypes();
        ageDivisions = findAgeDivisions();
    }

    public void showPreviousInfo(String tournamentName) {
        if ( tournamentName==null )
            return;
        connectedTournament = tournamentDAO.find(tournamentName);
        if( connectedTournament == null )
            return;

        view.setTournamentTitle( connectedTournament.getTitle());
        view.setLocation( connectedTournament.getLocation());
        view.setStartDate(connectedTournament.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        view.setFinishDate(connectedTournament.getFinishDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        view.setAgeDivision( getAgeDivisionIndex(connectedTournament.getAgeDivision().toString()) );
        view.setTeamsNumber(String.valueOf(connectedTournament.getMAX_TEAMS_NUMBER()));
        view.setSportType(getSportTypeIndex(connectedTournament.getSportType().getName()) );
        view.lockSportType();
    }

    public void onSaveTournament(){
        String title = view.getTournamentTitle();
        String location = view.getLocation();
        String startDate = view.getStartDate();
        String finishDate = view.getFinishDate();
        String ageDivision = ageDivisions.get( view.getAgeDivision() );
        String teamsNumber = view.getTeamsNumber() ;

        if (title.length() < 2 || title.length() > 20){

        }else{

            if (connectedTournament == null){
                ArrayList<String> basicInfo = new ArrayList<>(Arrays.asList(title, location , startDate , finishDate , ageDivision , teamsNumber));
                view.startSetDates( basicInfo );
            }else{
                connectedTournament.setTitle(title);
                connectedTournament.setLocation(location);
                connectedTournament.setStartDate(LocalDate.parse(startDate));
                connectedTournament.setFinishDate(LocalDate.parse(finishDate));
                connectedTournament.setAgeDivision( AgeDivision.values()[getAgeDivisionIndex(ageDivision)] );
                view.startSaveTournament(connectedTournament.getTitle());
            }

        }
    }

    public ArrayList<String> getSportTypes(){
        return sportTypes;
    }

    public ArrayList<String> getAgeDivisions(){
        return ageDivisions;
    }

    private int getSportTypeIndex(String sportType){
        for (int i = 0; i< sportTypes.size(); i++){
            if (sportTypes.get(i).equals(sportType) )
                return i;
        }
        return 0;
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

    private ArrayList<String> findAgeDivisions(){
        ArrayList<String> ageDivisions = new ArrayList<>();
        for (int i = 0; i< AgeDivision.values().length; i++){
            ageDivisions.add(AgeDivision.values()[i].toString());
        }
        return ageDivisions;
    }


    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(CreateTournamentView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

}
