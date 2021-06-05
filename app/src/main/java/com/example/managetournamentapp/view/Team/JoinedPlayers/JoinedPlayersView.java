package com.example.managetournamentapp.view.Team.JoinedPlayers;



import androidx.appcompat.app.AlertDialog;


public interface JoinedPlayersView {

    void changesOfAccess(boolean flag, boolean flag2);


    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);
    void backToTeamPage();
}
