package com.example.managetournamentapp.view.Player.PlayerPage;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

public class PlayerPagePresenter {
    private PlayerPageView view;
    private Player player;
    private PlayerDAO playerDAO;


    public PlayerPagePresenter(){}

    public void findPlayerInfo(String playerUsername){
        if ( playerUsername == null )
            return;
        player = playerDAO.find(playerUsername);
    }

    public void findAccess(){
        if ( MemoryLoggedInUser.getUser() != null )
            if (MemoryLoggedInUser.getUser() instanceof  Player)
                if ( (MemoryLoggedInUser.getUser()).equals(player) )
                    return;
        view.changesOfAccess();
    }


    public void setPlayerDAO(PlayerDAO playerDAO){
        this.playerDAO = playerDAO;
    }

    public String getPlayerName(){
        if (player==null)
            return "";

        return player.getName();
    }

    public void onPlayerAccount(){
        view.toPlayerInfo(player.getCredentials().getUsername());
    }

    public void onPlayerTeams(){
        view.toPlayerTeams(player.getCredentials().getUsername());
    }

    public void onPlayerInvites(){
        view.toPlayerInvites(player.getCredentials().getUsername());
    }

    public void setView(PlayerPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }


}
