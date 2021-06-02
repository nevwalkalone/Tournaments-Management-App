package com.example.managetournamentapp.view.Player.PlayerPage;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;

public class PlayerPagePresenter {
    private PlayerPageView view;
    private LoggedInUser loggedInUser;
    private Player player;
    private PlayerDAO playerDAO;


    public PlayerPagePresenter() {
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void findPlayerInfo(String playerUsername) {
        if (playerUsername == null)
            return;
        player = playerDAO.find(playerUsername);
    }

    public void findAccess() {
        System.out.println(player);
        System.out.println((Player) loggedInUser.getUser());
        if (loggedInUser.getUser() != null)
            if (loggedInUser.getUser() instanceof Player)
                if (((Player) loggedInUser.getUser()).equals(player))
                    return;
        view.changesOfAccess();
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public String getPlayerName() {
        if (player == null)
            return "";

        return player.getName();
    }

    public void onPlayerAccount() {
        view.toPlayerAccount();
    }

    public void onPlayerTeams() {
        view.toPlayerTeams();
    }

    public void onPlayerInvites() {
        view.toPlayerInvites();
    }

    public void setView(PlayerPageView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }


}
