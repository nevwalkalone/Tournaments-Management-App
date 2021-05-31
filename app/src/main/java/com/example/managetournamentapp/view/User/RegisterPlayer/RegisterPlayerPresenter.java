package com.example.managetournamentapp.view.User.RegisterPlayer;

import com.example.managetournamentapp.dao.LoggedInUserDAO;
import com.example.managetournamentapp.dao.LoggedInUserDAO;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;

public class RegisterPlayerPresenter {

    private RegisterPlayerViewModel view;
    private PlayerDAO players;
    private Player player;

    public RegisterPlayerPresenter(RegisterPlayerViewModel view, PlayerDAO players) {
        this.view = view;
        this.players = players;

        String playerUser = view.getPlayerUniqueUsername();
        if (playerUser != null) {
            player = players.find(playerUser);
        }

    }

    public void clearView() {
        this.view = null;
    }

}
