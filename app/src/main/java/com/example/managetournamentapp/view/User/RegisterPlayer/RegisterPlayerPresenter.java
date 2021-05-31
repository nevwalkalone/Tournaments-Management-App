package com.example.managetournamentapp.view.User.RegisterPlayer;

import com.example.managetournamentapp.dao.LoggedInUserDAO;
import com.example.managetournamentapp.dao.LoggedInUserDAO;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageView;

public class RegisterPlayerPresenter {

    private RegisterPlayerView view;
    private PlayerDAO playerDAO;
    private Player connectedPlayer;

    public RegisterPlayerPresenter() {

    }

    public void onSavePlayer(){

        //todo
    }

    public void setView(RegisterPlayerView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

}
