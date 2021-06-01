package com.example.managetournamentapp.view.Organizer.OrganizerPage;

public class OrganizerPagePresenter {
    private OrganizerPageView view;

    public OrganizerPagePresenter(){

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
