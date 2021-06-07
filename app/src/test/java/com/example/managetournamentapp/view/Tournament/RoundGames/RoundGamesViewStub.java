package com.example.managetournamentapp.view.Tournament.RoundGames;

import com.example.managetournamentapp.domain.Game;

public class RoundGamesViewStub implements RoundGamesView {
    boolean onHome = false, onPop = false;

    @Override
    public void showToast(String test) {

    }

    @Override
    public void showPopup(Game game) {
        onPop = true;
    }

    @Override
    public void recreateView() {

    }

    @Override
    public void backToHomePage(boolean flag, String string) {
        onHome = true;
    }
}
