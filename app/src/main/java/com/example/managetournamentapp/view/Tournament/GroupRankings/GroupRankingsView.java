package com.example.managetournamentapp.view.Tournament.GroupRankings;

import com.example.managetournamentapp.domain.Team;

import java.util.ArrayList;

public interface GroupRankingsView {

    ArrayList<Team> getTeamsList();

    void backToHomePage(boolean flag, String string);

}
