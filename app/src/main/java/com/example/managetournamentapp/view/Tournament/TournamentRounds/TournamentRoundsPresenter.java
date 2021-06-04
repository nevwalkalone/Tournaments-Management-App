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
        view.showRoundGames(tournament.getTitle(),tournament.getMAX_TEAMS_NUMBER());
    }

    public void on16(){

        view.showRoundGames(tournament.getTitle(),16 );
    }

    public void on8(){
        view.showRoundGames(tournament.getTitle(),8);
    }

    public void onSemifinals(){
        view.showRoundGames(tournament.getTitle(),4);
    }

    public void onFinal(){
        view.showRoundGames(tournament.getTitle(),2);
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
