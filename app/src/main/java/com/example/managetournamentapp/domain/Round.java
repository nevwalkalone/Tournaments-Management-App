package com.example.managetournamentapp.domain;

import android.util.Log;

import java.time.LocalDate;
import java.util.*;
public class Round {

    private int teamsNumber,teamsPerGroup;
    private boolean isKnockout;
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<LocalDate> dates;
    private ArrayList<Team> teams;

    public Round(int teamsNumber, boolean isKnockout , ArrayList<LocalDate> dates) {
        this.teamsNumber = teamsNumber;
        this.isKnockout = isKnockout;
        this.dates = dates;
        initGroups();
    }

    public void initGroups(){
        teamsPerGroup = 4;
        if (isKnockout){
            teamsPerGroup = 2;
        }
        int groupsNumber = teamsNumber / teamsPerGroup;
        int groupMatches = dates.size()/groupsNumber;
        int firstIndex = 0;
        int lastIndex = groupMatches;
        for (int i=0; i< groupsNumber ; i++){
            groups.add(new Group(isKnockout, new ArrayList<>(dates.subList(firstIndex, lastIndex)) ));
            firstIndex = lastIndex;
            lastIndex += groupMatches;
        }
    }

    public void setup(ArrayList<Team> teams){
        this.teams = teams;
        int firstIndex = 0;
        int lastIndex = teamsPerGroup;
        for (int i=0; i< groups.size() ; i++){
            groups.get(i).addTeams( new ArrayList<>(teams.subList(firstIndex,lastIndex)) );
            firstIndex = lastIndex;
            lastIndex += teamsPerGroup;
        }
    }

    public boolean allGamesFinished() {
        for (Group group : groups) {
            if (!group.allGamesFinished())
                return false;
        }
        return true;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Team> getRoundWinners(){
        ArrayList<Team> winners = new ArrayList<>();
        if (!allGamesFinished()){
            return winners;
        }
        for (Group group : groups) {
            group.refreshRankings();
            winners.addAll( group.getGroupWinners() );
        }
        return winners;
    }

    public ArrayList<LocalDate> getDates() {
        return new ArrayList<>(dates);
    }

    public ArrayList<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    public int getTeamsNumber() {
        return teamsNumber;
    }

    public int getTeamsPerGroup() {
        return teamsPerGroup;
    }


    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if (other instanceof Round) {
            Round otherRound = (Round) other;
            if (teamsNumber == otherRound.teamsNumber && teamsPerGroup == otherRound.teamsPerGroup
                    && groups.equals(otherRound.groups) && isKnockout == otherRound.isKnockout
                        && dates.equals(otherRound.dates))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Round{" +
                "teamsNumber=" + teamsNumber +
                '}';
    }

}
