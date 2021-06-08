package com.example.managetournamentapp.view.Team.TeamPage;

public interface TeamPageView {

    /**
     * when the "info" button is pressed
     * the team info activity starts
     */
    void startTeamInfo();

    /**
     * when the "players" button is pressed
     * the participating players activity starts
     */
    void startTeamPlayers();

    /**
     * when the "participations" button is pressed
     * the participations activity starts
     */
    void startTeamParticipations();

    /**
     *only the players of this team can see
     * the participations of this team
     */
    void changesOfAccess();

    /**
     * what happens when the homepage button is pressed
     * @param flag is true if the logged in user is a player
     * @param string is the name of a player. or the title of an organizer
     */
    void backToHomePage(boolean flag, String string);
}
