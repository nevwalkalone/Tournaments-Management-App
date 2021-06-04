package com.example.managetournamentapp.view.Team.InvitePlayers;

import androidx.appcompat.app.AlertDialog;

import com.example.managetournamentapp.domain.Player;

public interface InvitePlayersView {
    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);

    void startPlayerPage(Player player);
}
