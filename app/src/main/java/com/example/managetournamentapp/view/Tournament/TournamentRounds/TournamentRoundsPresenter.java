package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;

public class TournamentRoundsPresenter {
    private TournamentRoundsView view;
    private Tournament tournament;
    private TournamentDAO tournamentDAO;

    public TournamentRoundsPresenter(){

    }

    public void findTournamentInfo(String tournamentName){
        if(tournamentName ==null){
            return;
        }
        tournament = tournamentDAO.find(tournamentName);
        if( tournament == null )
            return;

    }

    public void findAccess(){
        view.changesOfAccess(tournament.getMAX_TEAMS_NUMBER());
    }

    public void onGroups(){

        view.showGroupRound(tournament.getTitle());
    }

    public void on16(){

        view.showRound16(tournament.getTitle());
    }

    public void on8(){

        view.showRound8(tournament.getTitle());
    }

    public void onSemifinals(){

        view.showSemifinals(tournament.getTitle());
    }

    public void onFinal(){

        view.showFinal(tournament.getTitle());
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(TournamentRoundsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
