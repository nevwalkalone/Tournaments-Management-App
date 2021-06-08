package com.example.managetournamentapp.view.Tournament.RoundGames;

import com.example.managetournamentapp.domain.Game;

public interface RoundGamesView {

    /**
     * show a toast on the screen
     * @param text the message of the toast
     */
    void showToast(String test);

    /**
     * when the organizer presses on a game
     * they can set the score of the game
     * @param game the game that was pressed on
     */
    void showPopup(Game game);

    /**
     * refresh the current activity
     */
    void recreateView();

    /**
     * what happens when the homepage button is pressed
     * @param flag is true if the logged in user is a player
     * @param string is the name of a player. or the title of an organizer
     */
    void backToHomePage(boolean flag, String string);
}
