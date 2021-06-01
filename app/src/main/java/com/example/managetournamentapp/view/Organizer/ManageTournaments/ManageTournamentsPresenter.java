package com.example.managetournamentapp.view.Organizer.ManageTournaments;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.util.Quadruple;

import java.util.ArrayList;

public class ManageTournamentsPresenter {

    private ManageTournamentsView view;

    private TournamentDAO tournaments;
    private OrganizerDAO organizers;
    private String orgName;

    public ManageTournamentsPresenter(ManageTournamentsView view, TournamentDAO tournaments, OrganizerDAO organizers, String orgName) {
        this.view = view;
        this.tournaments = tournaments;
        this.organizers = organizers;
        this.orgName = orgName;

        onLoadSource();
    }

    private ArrayList<Quadruple> createDataSource(ArrayList<Tournament> tournaments) {
        ArrayList<Quadruple> triplets = new ArrayList<>();
        // for (Tournament tournaments: tournaments){

        //}
        return null;
    }

    /**
     * Ξεκινάει το activity AddEditBookActivity
     */
    void onStartAddNew() {
        view.startAddNew();
    }

    public void onClickItem(int uid) {
        view.clickItemList(uid);
    }


    void onLoadSource() {
        ArrayList<Tournament> new_tourns;
        Organizer organizer = organizers.findByTitle(orgName);
        new_tourns = new ArrayList<>(organizer.getTournaments());

        view.loadSource(createDataSource(new_tourns));
    }
}
