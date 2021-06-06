package com.example.managetournamentapp.view.HomePage;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class HomePagePresenter {

    private HomePageView view;

    public HomePagePresenter() {
    }


    public void onConnectAction() {
        view.connectAction();
    }

    public void onBrowseAction() {
        view.browseAction();
    }

    public void onLogInAction() {
        view.loginAction();
    }

    public void onRegisterAction() {
        view.registerAction();
    }

    public void onOrganizerRegisterAction() {
        view.organizerRegisterAction();
    }

    public void onPlayerRegisterAction() {
        view.playerRegisterAction();
    }

    public void setView(HomePageView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

}
