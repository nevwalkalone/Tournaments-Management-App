package com.example.managetournamentapp.view.Player.ReceivedInvites;

import androidx.appcompat.app.AlertDialog;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

import java.util.ArrayList;
import java.util.Arrays;

public class ReceivedInvitesViewStub implements ReceivedInvitesView {
    AlertDialog dialog;
    ArrayList<Invitation> invitations = new PlayerDAOMemory().find("gioza").getInvitesReceived();
    boolean onTeam = false, onHome = false;

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, int btn3, boolean flag) {
        return dialog;
    }

    @Override
    public void startTeamPage() {
        onTeam = true;
    }

    @Override
    public ArrayList<Invitation> getInvitationsList() {
        return invitations;
    }

    @Override
    public void backToHomePage() {
        onHome = true;
    }
}
