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
    void browseAction();

    void loginAction();

    void registerAction();

    void organizerRegisterAction();

    void playerRegisterAction();




}
