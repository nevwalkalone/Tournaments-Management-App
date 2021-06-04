package com.example.managetournamentapp.view.Player.ReceivedInvites;

import androidx.appcompat.app.AlertDialog;

import com.example.managetournamentapp.domain.Invitation;

import java.util.ArrayList;

public interface ReceivedInvitesView {
    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, int btn3,boolean flag);

    void startTeamPage();

    ArrayList<Invitation> getInvitationsList();

}
