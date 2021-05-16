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

    public void setupRound(ArrayList<Team> teams){
        int firstIndex = 0;
        int lastIndex = teamsPerGroup;
        for (int i=0; i< groups.size() ; i++){
            groups.get(i).addTeams(teams.subList(firstIndex,lastIndex));
            firstIndex = lastIndex;
            lastIndex += teamsPerGroup;
        }
    }

    public void passWinnersToNext(Round round){
        round.setupRound(getRoundWinners() );
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public int getTeamsNumber() {
        return teamsNumber;
    }

    public boolean equals(Object other) {

        boolean equal = false;
        if (other instanceof Round) {
            Round otherRound = (Round) other;
            if (teamsNumber == otherRound.teamsNumber && teamsPerGroup == otherRound.teamsPerGroup
                    && groups.equals(otherRound.groups) && isKnockout == otherRound.isKnockout
                        && dates.equals(otherRound.dates))
                equal = true;
        }
        return equal;
    }



    @Override
    public String toString() {
        return "Round{" +
                "teamsNumber=" + teamsNumber +
                '}';
    }

}
