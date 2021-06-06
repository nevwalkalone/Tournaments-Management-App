package com.example.managetournamentapp.view.HomePage;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class HomePagePresenter {

    private HomePageView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public HomePagePresenter() {
    }


    public ArrayList<Tournament> getResults() {
        return results;
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

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void clearView() {
        this.view = null;
    }

}
