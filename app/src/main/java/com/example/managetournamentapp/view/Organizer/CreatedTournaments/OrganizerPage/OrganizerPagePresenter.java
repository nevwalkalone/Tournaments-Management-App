package com.example.managetournamentapp.view.Organizer.CreatedTournaments.OrganizerPage;

public class OrganizerPagePresenter {
    private OrganizerPageView view;

    public OrganizerPagePresenter(){

    }

    public void setView(OrganizerPageView view) {
        this.view = view;
    }


    public void clearView(){
        this.view = null;
    }
}
