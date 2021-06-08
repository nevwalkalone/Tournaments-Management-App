package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

public interface ParticipatingTeamsView {

    /**
     * show the page of the chosen team
     * @param teamname the name of the team
     */
    void startTeamPage(String teamname);

    /**
     * what happens when the homepage button is pressed
     * @param flag is true if the logged in user is a player
     * @param string is the name of a player. or the title of an organizer
     */
    void backToHomePage(boolean flag, String string);
}
