package com.example.managetournamentapp.view.User.RegisterPlayer;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.LoggedInUserDAO;
import com.example.managetournamentapp.domain.Player;

public class RegisterPlayerPresenter {

    private RegisterPlayerView view;
    private LoggedInUserDAO users;
    private Player player;

    public RegisterPlayerPresenter(RegisterPlayerView view, LoggedInUserDAO users) {
        this.view = view;
        this.users = users;

        String playerUser = view.getPlayerUniqueUsername();
    }

}
