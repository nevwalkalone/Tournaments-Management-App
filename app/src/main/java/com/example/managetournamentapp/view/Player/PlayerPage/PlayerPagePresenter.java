package com.example.managetournamentapp.view.Player.PlayerPage;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.domain.Player;

public class PlayerPagePresenter {
    private PlayerPageView view;
    private LoggedInUser loggedInUser;


    public PlayerPagePresenter(){}

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public String getPlayerName(){
        return ( (Player) loggedInUser.getUser() ).getName();
    }

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
