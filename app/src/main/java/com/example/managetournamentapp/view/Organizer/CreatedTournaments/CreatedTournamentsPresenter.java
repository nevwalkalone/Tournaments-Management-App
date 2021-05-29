package com.example.managetournamentapp.view.Organizer.CreatedTournaments;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class CreatedTournamentsPresenter {
    private CreatedTournamentsView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public CreatedTournamentsPresenter(){}

    public void findCreatedTournaments(Organizer organizer){
        results.clear();
        results.addAll( organizer.getTournaments()  );
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void onTournamentSelected(Tournament t){
        // todo
    }

    public void setView(CreatedTournamentsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }


}
