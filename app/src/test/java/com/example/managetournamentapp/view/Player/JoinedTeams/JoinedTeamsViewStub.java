package com.example.managetournamentapp.view.Player.JoinedTeams;

public class JoinedTeamsViewStub implements JoinedTeamsView {
    boolean onAdd = false, onHome = false, onChange = false;

    @Override
    public void startAddTeam() {
        onAdd = true;
    }

    @Override
    public void changesOfAccess() {
        onChange = true;
    }

    @Override
    public void backToHomePage() {
        onHome = true;
    }
}
