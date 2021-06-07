package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

public class ParticipatingTournamentsViewStub implements ParticipatingTournamentsView {
    boolean onHome = false;

    @Override
    public void startAddParticipation() {

    }

    @Override
    public void changesOfAccess() {

    }

    @Override
    public void backToHomePage(String string) {
        onHome = true;
    }
}
