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
     * @param noLogin boolean parameter, if true the user has not logged in
     * @param isPlayer boolean parameter,if true the user is a player
     * @param name name of the player or title of the organizer
     */
    void backToHomePage(boolean noLogin, boolean isPlayer, String name);

}
