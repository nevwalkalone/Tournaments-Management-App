package com.example.managetournamentapp.view.Player.ReceivedInvites;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;

public class ReceivedInvitesPresenter {
    private ReceivedInvitesView view;
    private LoggedInUser loggedInUser;
    private Player player;
    private PlayerDAO playerDAO;


    public ReceivedInvitesPresenter(){}

    public void findPlayerInfo(String playerUsername){
        if ( playerUsername == null )
            return;
        player = playerDAO.find(playerUsername);
    }
    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setPlayerDAO(PlayerDAO playerDAO){
        this.playerDAO = playerDAO;
    }

    public String getPlayerName(){
        if (player==null)
            return "";

        return player.getName();
    }


    public void setView(ReceivedInvitesView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }


}
