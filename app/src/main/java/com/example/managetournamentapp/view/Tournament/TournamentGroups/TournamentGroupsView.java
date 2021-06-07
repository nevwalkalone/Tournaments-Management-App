package com.example.managetournamentapp.view.Tournament.TournamentGroups;


import androidx.appcompat.app.AlertDialog;

public interface TournamentGroupsView {
    void changesOfAccess(int groupsNumber);

    void showGroupGames(String tournamentGame, int roundTeamsNumber, int index);

    void showGroupRankings(String tournamentGame, int roundTeamsNumber, int index);

    void showPopup(int index);

    void backToHomePage(boolean flag, String string);

}
