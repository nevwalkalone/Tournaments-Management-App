package com.example.managetournamentapp.view.Team.AddParticipation;

import androidx.appcompat.app.AlertDialog;

import com.example.managetournamentapp.domain.Tournament;

public class AddParticipationViewStub implements  AddParticipationView{

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, boolean flag) {
        return null;
    }

    @Override
    public void startTournamentPage(Tournament tournament) {

    }

    @Override
    public void startPlayerPage(String userName) {

    }
}
