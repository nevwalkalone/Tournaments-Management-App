package com.example.managetournamentapp.view.Tournament.TournamentPage;

import com.example.managetournamentapp.domain.Tournament;

public class TournamentPagePresenter {
    private TournamentPageView view;
    private Tournament tournament;

    public TournamentPagePresenter(){

    }

    public void onTournamentInfo(){
        view.startTournamentInfo();
    }
    public void onTournamentTeams(){
        view.startTeamsParticipating();
    }

    public void onTournamentGames(){
        view.startTournamentGames();
    }

    public void setView(TournamentPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }
}
