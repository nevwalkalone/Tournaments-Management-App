package com.example.managetournamentapp.view.Team.InvitePlayers;

import androidx.appcompat.app.AlertDialog;

public interface InvitePlayersView {
    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);
}
