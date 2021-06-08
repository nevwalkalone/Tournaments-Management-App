package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

public interface ParticipatingTournamentsView {

    /**
     * show the page of new participations
     */
    void startAddParticipation();

    /**
     * only the captain can create a new participation
     */
    void changesOfAccess();

    /**
     * what happens when the homepage button is pressed
     * @param string is the name of a player. or the title of an organizer
     */
    void backToHomePage(String string);

}
