package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;

public class TournamentGroupsPresenter {
    private TournamentGroupsView view;
    private Tournament tournament;
    private TournamentDAO tournamentDAO;


    public TournamentGroupsPresenter(){    }

    public void findTournamentInfo(String tournamentName){
        if(tournamentName ==null){
            return;
        }
        tournament = tournamentDAO.find(tournamentName);
        if( tournament == null )
            return;

    }

    public void findAccess(){
        view.changesOfAccess(tournament.getRounds().get(0).getGroups().size() );
    }

    public void onGroup(int index){
        view.showGroup(tournament.getTitle(), index );
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(TournamentGroupsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
