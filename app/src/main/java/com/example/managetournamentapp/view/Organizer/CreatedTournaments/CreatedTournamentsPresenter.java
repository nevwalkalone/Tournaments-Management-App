package com.example.managetournamentapp.view.Organizer.CreatedTournaments;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class CreatedTournamentsPresenter {
    private CreatedTournamentsView view;
    private TournamentDAO tournamentDAO;
    private OrganizerDAO organizerDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public CreatedTournamentsPresenter(){}

    public void findCreatedTournaments(String organizerTitle){
        Organizer organizer = organizerDAO.findByTitle(organizerTitle);
        if (organizer==null)
            return;
        results.clear();
        results.addAll( organizer.getTournaments()  );
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void onAddTournament(){
        view.startAddTournament();
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

    public void setOrganizerDAO(OrganizerDAO organizerDAO) {
        this.organizerDAO = organizerDAO;
    }

}
