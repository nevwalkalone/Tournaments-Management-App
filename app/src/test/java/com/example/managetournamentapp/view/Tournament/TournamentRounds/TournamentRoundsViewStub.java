package com.example.managetournamentapp.view.Tournament.TournamentRounds;

public class TournamentRoundsViewStub implements TournamentRoundsView {
    boolean onChange = false, onRound = false, onGroups = false, onHome = false;

    @Override
    public void changesOfAccess(int teamsNumber) {
        onChange = true;
    }

    @Override
    public void showRoundGames(String tournamentTitle, int roundTeamsNumber) {
        onRound = true;
    }

    @Override
    public void showGroups(String tournamentTitle, int roundTeamsNumber) {
        onGroups = true;
    }

    @Override
    public void backToHomePage(boolean noLogin, boolean isPlayer, String name) {
        onHome = true;
    }
}
