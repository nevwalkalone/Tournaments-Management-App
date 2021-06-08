package com.example.managetournamentapp.view.Tournament.GroupRankings;

import com.example.managetournamentapp.domain.Team;

import java.util.ArrayList;

public interface GroupRankingsView {

    /**
     * get the list of the teams in the group
     * @return the ArrayList of teams
     */
    ArrayList<Team> getTeamsList();

    /**
     * what happens when the homepage button is pressed
     * @param isPlayer is true if the logged in user is a player
     * @param name is the name of a player. or the title of an organizer
     */
    void backToHomePage(boolean isPlayer, String name);

}
