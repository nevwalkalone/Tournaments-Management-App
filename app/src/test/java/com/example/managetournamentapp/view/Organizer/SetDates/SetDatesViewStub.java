package com.example.managetournamentapp.view.Organizer.SetDates;

import java.util.ArrayList;
import java.util.Arrays;

public class SetDatesViewStub implements SetDatesView{
    ArrayList<String> dates = new ArrayList<String>(Arrays.asList("08/08/2021", "08/08/2021", "08/08/2021","08/08/2021","08/08/2021","08/08/2021"));
    @Override
    public void startSaveTournament(String tournamentName) {

    }

    @Override
    public ArrayList<String> getDates() {
        return this.dates;
    }

    @Override
    public void showPopUp(SetDatesView view, String msg) {

    }

    @Override
    public void backToHomePage(boolean isPlayer, String name) {

    }
}
