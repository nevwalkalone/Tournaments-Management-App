package com.example.managetournamentapp.view.Tournament.TournamentPage;

public class TournamentPageViewStub implements TournamentPageView {
    boolean onInfo = false, onTeams = false, onGames = false, onHome = false;

    @Override
    public void startTournamentInfo() {
        onInfo = true;
    }

    @Override
    public void startTeamsParticipating() {
        onTeams = true;
    }

    @Override
    public void startTournamentGames() {
        onGames = true;
    }

    @Override
    public void backToHomePage(boolean flag, String string) {
        onHome = true;
    }
}
