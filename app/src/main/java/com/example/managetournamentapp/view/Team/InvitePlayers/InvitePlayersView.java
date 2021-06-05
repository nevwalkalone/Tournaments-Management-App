package com.example.managetournamentapp.view.Team.InvitePlayers;

import androidx.appcompat.app.AlertDialog;

import com.example.managetournamentapp.domain.Player;

public interface InvitePlayersView {
    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2,boolean flag);

    void startPlayerPage(Player player);
}
