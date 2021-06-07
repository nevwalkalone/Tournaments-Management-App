package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

public class ParticipatingTeamsViewStub implements ParticipatingTeamsView {
    boolean onHome = false, onTeam = false;

    @Override
    public void checkTeam() {

    }

    @Override
    public void startTeamPage(String teamname) {
        onTeam = true;
    }

    @Override
    public void backToHomePage(boolean flag, String string) {
        onHome = true;
    }
}
