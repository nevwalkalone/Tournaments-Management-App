package com.example.managetournamentapp.view.Organizer.SetDates;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public interface SetDatesView {

    void startSaveTournament(String tournamentName);

    ArrayList<String> getDates();

    void showPopUp(SetDatesView view, String msg);

    void backToHomePage(boolean isPlayer, String name);
}
