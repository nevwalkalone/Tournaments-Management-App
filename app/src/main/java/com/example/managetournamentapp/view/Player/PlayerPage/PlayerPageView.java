package com.example.managetournamentapp.view.Player.PlayerPage;

import androidx.appcompat.app.AlertDialog;

public interface PlayerPageView {

    void toPlayerInfo(String playerUsername);

    void toPlayerTeams(String playerUsername);

    void toPlayerInvites(String playerUsername);

    void changesOfAccess();

    void logOut();

    void displayPopUpAction(int layout, String msg, int btn1, int btn2);

    void dismissPopUpAction();

    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);

    void logOutConfirmation();

    void noLogOut();

}
