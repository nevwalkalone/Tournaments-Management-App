package com.example.managetournamentapp.view.Tournament.TournamentRounds;

public interface TournamentRoundsView {
    void changesOfAccess(int teamsNumber);

    void showRoundGames(String tournamentTitle, int roundTeamsNumber);

    void showGroups(String tournamentTitle, int roundTeamsNumber);


    void backToHomePage(boolean flag, String string);


}
