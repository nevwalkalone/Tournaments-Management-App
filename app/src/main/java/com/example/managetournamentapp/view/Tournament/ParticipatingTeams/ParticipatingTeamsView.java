package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

public interface ParticipatingTeamsView {

    /**
     * show the page of the chosen team
     * @param teamname the name of the team
     */
    void startTeamPage(String teamname);

    /**
     * what happens when the homepage button is pressed
     * @param noLogin boolean parameter, if true the user has not logged in
     * @param isPlayer boolean parameter,if true the user is a player
     * @param name name of the player or title of the organizer
     */
    void backToHomePage(boolean noLogin, boolean isPlayer, String name);
}
