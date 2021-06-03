package com.example.managetournamentapp.view.Team.JoinedPlayers;

import android.view.View;

import androidx.appcompat.app.AlertDialog;


public interface JoinedPlayersView {
    void changesOfAccess();

    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);
}
