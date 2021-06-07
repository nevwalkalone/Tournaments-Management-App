package com.example.managetournamentapp.view.User.Browsing;

public class BrowsingViewStub implements BrowsingView {
    boolean onTournament = false;

    @Override
    public void startTournamentPage(String title) {
        onTournament = true;
    }
}
