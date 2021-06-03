package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Tournament;

public class TournamentInfoPresenter {
    private TournamentInfoView view;
    private Tournament tournament;
    private TournamentDAO tournamentDAO;
    private LoggedInUser loggedInUser;

    public TournamentInfoPresenter(){
    }

    public void findTournamentInfo(String tournamentName){
        if(tournamentName ==null){
            return;
        }
        tournament = tournamentDAO.find(tournamentName);
        if( tournament == null )
            return;

        view.setTitle(tournament.getTitle());
        view.setLocation(tournament.getLocation());
        view.setFinishDate(tournament.getFinishDate().toString());
        view.setLocation(tournament.getLocation());
        view.setsportType(tournament.getSportType().getName());
        view.setStartDate(tournament.getStartDate().toString());
        view.setTeamsNumber(String.valueOf(tournament.getMAX_TEAMS_NUMBER()));
        view.setAgeDivision(tournament.getAgeDivision().toString());
        view.setDescription(tournament.getDescription());

    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof Organizer)
                if ( ((Organizer)loggedInUser.getUser()).getTournaments().contains(tournament) )
                    return;
        view.changesOfAccess();
    }

    //TODO CHECKING
    public void onEditTournament(){
        view.startEditTournament();
    }

    //TODO CHECKING
    public void onDeleteTournament(){
        tournamentDAO.delete(tournament);
        view.startDeleteTournament();
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(TournamentInfoView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }
}
