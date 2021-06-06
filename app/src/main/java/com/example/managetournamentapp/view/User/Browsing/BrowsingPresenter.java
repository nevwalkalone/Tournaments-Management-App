package com.example.managetournamentapp.view.User.Browsing;

import android.content.Intent;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class BrowsingPresenter {
    private BrowsingView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public BrowsingPresenter() {
    }

    public void findAllTournaments() {
        results.clear();
        results = tournamentDAO.findAll();
    }

    public void startTournamentPage(Tournament tournament) {
        view.startTournamentPage(tournament.getTitle());
    }

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
