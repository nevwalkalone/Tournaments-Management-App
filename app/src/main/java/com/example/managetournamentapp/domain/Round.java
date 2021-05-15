package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.*;
public class Round {

    private int teamsNumber,teamsPerGroup;
    private ArrayList<Group> groups = new ArrayList<>();
    private boolean isKnockout;
    private List<LocalDate> dates;

    public Round(int teamsNumber, boolean isKnockout , List<LocalDate> dates) {
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
            groups.add(new Group(isKnockout, dates.subList(firstIndex, lastIndex ) ));
            firstIndex = lastIndex;
            lastIndex += groupMatches;
        }
    }

    public boolean allGamesFinished() {
        for (Group group : groups) {
            if (!group.allGamesFinished())
                return false;
        }
        return true;
    }

//
//    public void enterTeams(ArrayList<Team> teams){
//        int groupsNumber = teamsNumber / teamsPerGroup;
//        int groupMatches = dates.size()/groupsNumber;
//        int firstIndex = 0;
//        int lastIndex = groupMatches;
//        for (int i=0; i< groupsNumber ; i++) {
//            groups.add(new Group(isKnockout, dates.subList(firstIndex, lastIndex)));
//            firstIndex = lastIndex;
//            lastIndex += groupMatches;
//        }
//    }

    public ArrayList<Team> getRoundWinners(){
        ArrayList<Team> qualifiedTeams = new ArrayList<>();
        if (!allGamesFinished()){
            return qualifiedTeams;
        }
        for (Group group : groups) {
            qualifiedTeams.addAll( group.getGroupWinners() );
        }
        return qualifiedTeams;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public int getTeamsNumber() {
        return teamsNumber;
    }


    @Override
    public String toString() {
        return "Round{" +
                "teamsNumber=" + teamsNumber +
                '}';
    }


}
