package com.example.managetournamentapp.view.Team.TeamPage;

public class TeamPageViewStub implements TeamPageView {
    public boolean changed = false, onHome = false;

    @Override
    public void startTeamInfo() {

    }

    @Override
    public void startTeamPlayers() {

    }

    @Override
    public void startTeamParticipations() {

    }

    @Override
    public void changesOfAccess() {
        changed = true;
    }

    @Override
    public void backToHomePage(boolean noLogin, boolean isPlayer, String name) {
        onHome = true;

    }


}
