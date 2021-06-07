package com.example.managetournamentapp.view.User.Browsing;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;
import java.util.ArrayList;

public class BrowsingPresenter {
    private BrowsingView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    /**
     * default constructor
     */
    public BrowsingPresenter() {
    }

    /**
     * find all the tournaments
     */
    public void findAllTournaments() {
        results.clear();
        results = tournamentDAO.findAll();
    }

    /**
     * start the tournament page activity
     * @param tournament the tournament
     */
    public void startTournamentPage(Tournament tournament) {
        view.startTournamentPage(tournament.getTitle());
    }

    /**
     * get all the tournaments
     * @return the arraylist of tournaments
     */
    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void setView(BrowsingView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

}
