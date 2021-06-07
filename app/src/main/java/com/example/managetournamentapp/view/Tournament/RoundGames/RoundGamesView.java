package com.example.managetournamentapp.view.Tournament.RoundGames;

import com.example.managetournamentapp.domain.Game;

public interface RoundGamesView {

    void showToast(String test);

    void showPopup(Game game);

    void recreateView();


    void backToHomePage(boolean flag, String string);
}
