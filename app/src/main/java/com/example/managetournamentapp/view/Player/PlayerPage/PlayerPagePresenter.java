package com.example.managetournamentapp.view.Player.PlayerPage;

public class PlayerPagePresenter {
    private PlayerPageView view;


    public PlayerPagePresenter(){}


    public void onPlayerAccount(){
        view.toPlayerAccount();
    }

    public void onPlayerTeams(){
        view.toPlayerTeams();
    }

    public void onPlayerInvites(){
        view.toPlayerInvites();
    }

    public void setView(PlayerPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }




}
