package com.example.managetournamentapp.view.Tournament.TournamentGroups;

public interface TournamentGroupsView {

    /**
     * hide the button of a group
     * if this group doesn't exist in the tournament
     * @param groupsNumber the number of groups in the first round
     */
    void changesOfAccess(int groupsNumber);

    /**
     * show the games of a group
     * @param tournamentTitle the title of the tournament
     * @param roundTeamsNumber the number of the teams in this round
     * @param index the index of the particular group
     */
    void showGroupGames(String tournamentTitle, int roundTeamsNumber, int index);

    /**
     * show the rankings of the teams in a group
     * @param tournamentTitle the title of the tournament
     * @param roundTeamsNumber the number of the teams in this round
     * @param index the index of the particular group
     */
    void showGroupRankings(String tournamentTitle, int roundTeamsNumber, int index);

    /**
     * when the user presses on a group
     * a popup is shown, where he can choose to view the
     * games or the rankings of this group
     * @param index the index of the group that was pressed
     */
    void showPopup(int index);

    /**
     * what happens when the homepage button is pressed
     * @param flag is true if the logged in user is a player
     * @param string is the name of a player. or the title of an organizer
     */
    void backToHomePage(boolean flag, String string);

}
