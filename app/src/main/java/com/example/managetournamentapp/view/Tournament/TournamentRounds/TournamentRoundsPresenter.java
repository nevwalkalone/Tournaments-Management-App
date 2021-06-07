package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

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
        view.showGroups(tournament.getTitle(),tournament.getMAX_TEAMS_NUMBER());
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
