package com.example.managetournamentapp.view.HomePage;

public interface HomePageView {

    /**
     * When app user clicks on Connect Button,
     * the app redirects the user to the ConnectActivity
     */
    void connectAction();

    /**
     * When app user clicks on any team, on the browsing list,
     * the app redirects the user to the TeamPageActivity
     */
    void teamOnBrowsingSelection();

    void returnSearchResult(int id);

}
