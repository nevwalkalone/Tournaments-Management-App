package com.example.managetournamentapp.view.HomePage;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

import java.util.ArrayList;

public class HomePagePresenter {



    public HomePagePresenter(HomePageView view) {
        this.view = view;
    }

    private HomePageView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public HomePagePresenter() {
    }

    public void findTournaments() {
        results.clear();
        results.addAll((new TournamentDAOMemory()).findAll());
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void onTournamentSelected(Tournament t) {
        // todo
    }

    public void setView(HomePageView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

}
