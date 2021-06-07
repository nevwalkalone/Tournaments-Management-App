package com.example.managetournamentapp.view.Team.JoinedPlayers;


import androidx.appcompat.app.AlertDialog;


public interface JoinedPlayersView {

    void changesOfAccess(boolean flag, boolean flag2);


    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);

    void startPlayerInfo();

    void startInvitePlayerPage();

    void displayPopUpAction(int layout, String msg, int btn1, int btn2);

    void displayPopUpDeletion(int layout, String msg, int btn1, int btn2);

    void dismissPopUpAction();

    void dismissPopUpDeletion();

    void resetPopUps();

    void restartActivity();

    void backToHomePage(boolean flag, String string);
}
