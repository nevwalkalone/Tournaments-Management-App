package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.User;

public class OrganizerPagePresenter {
    private OrganizerPageView view;
    private Organizer organizer = null;

    public OrganizerPagePresenter(){

    }

    public void setOrganizer(User user){
        if (user == null)
            return;
        if (!(user instanceof Organizer))
            return;
        organizer = (Organizer) user;

    }


    public void onOrganizerAccount(){
        view.toOrganizerAccount();
    }

    public void onOrganizerTournaments(){
        view.toOrganizerTournaments();
    }

    public void setView(OrganizerPageView view) {
        this.view = view;
    }


    public void clearView(){
        this.view = null;
    }
}
