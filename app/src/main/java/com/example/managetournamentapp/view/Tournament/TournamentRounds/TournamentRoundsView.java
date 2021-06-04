package com.example.managetournamentapp.view.Tournament.TournamentRounds;

public interface TournamentRoundsView {
    void changesOfAccess(int teamsNumber);

    void showGroupRound(String tournamentTitle);

    void showRound16(String tournamentTitle);

    void showRound8(String tournamentTitle);

    void showSemifinals(String tournamentTitle);

    void showFinal(String tournamentTitle);
}
