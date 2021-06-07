package com.example.managetournamentapp.view.Organizer.OrganizerTournaments;

public class OrganizerTournamentsViewStub implements OrganizerTournamentsView {
    boolean onCreate = false, onHome = false;

    @Override
    public void startCreateTournament() {
        onCreate = true;
    }

    @Override
    public void backToHomePage(String title) {
        onHome = true;
    }
}
