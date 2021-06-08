package com.example.managetournamentapp.view.Organizer.OrganizerTournaments;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public class OrganizerTournamentsPresenter {
    private OrganizerTournamentsView view;
    private TournamentDAO tournamentDAO;
    private String orgTitle;
    private OrganizerDAO organizerDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public OrganizerTournamentsPresenter(){}

    public void findCreatedTournaments(String organizerTitle){
        Organizer organizer = organizerDAO.findByTitle(organizerTitle);
        if (organizer==null)
            return;
        orgTitle = organizer.getTitle();
        results.clear();
        results.addAll( organizer.getTournaments()  );
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void onAddTournament(){
        view.startCreateTournament();
    }

    public void setView(OrganizerTournamentsView view) {
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

    public void onHomePage(){
        view.backToHomePage(orgTitle);
    }

}
