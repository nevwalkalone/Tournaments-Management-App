package com.example.managetournamentapp.view.Tournament.TournamentPage;



public interface TournamentPageView {

    /**
     * when the "info" button is pressed
     * the tournament info activity starts
     */
    void startTournamentInfo();

    /**
     * when the "teams" button is pressed
     * the participating teams activity starts
     */
    void startTeamsParticipating();

    /**
     * when the "games" button is pressed
     * the tournament rounds activity starts
     */
    void startTournamentGames();

    /**
     * what happens when the homepage button is pressed
     * @param isPlayer is true if the logged in user is a player
     * @param name is the name of a player. or the title of an organizer
     */
    void backToHomePage(boolean isPlayer, String name);

}
