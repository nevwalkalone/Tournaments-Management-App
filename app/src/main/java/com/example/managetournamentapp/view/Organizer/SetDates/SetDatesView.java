package com.example.managetournamentapp.view.Organizer.SetDates;

import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentView;

import java.util.ArrayList;

public interface SetDatesView {

    void startSaveTournament(String tournamentName);

    ArrayList<String> getDates();

    void showPopUp(SetDatesView view, String msg);

    void backToHomePage(boolean isPlayer, String name);
}
