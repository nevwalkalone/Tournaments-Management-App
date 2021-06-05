package com.example.managetournamentapp.view.Team.AddParticipation;

import androidx.appcompat.app.AlertDialog;

import com.example.managetournamentapp.domain.Tournament;

public interface AddParticipationView {
    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, boolean flag);

    void startTournamentPage(Tournament tournament);

    void startPlayerPage(String userName);
}
