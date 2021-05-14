package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.*;
public class Round {

    private int teamsNumber;
    private ArrayList<Group> groups = new ArrayList<>();
    private boolean isKnockout;
    private List<LocalDate> dates;

    public Round(){
    }

    public Round(int teamsNumber, boolean isKnockout , List<LocalDate> dates) {
        setTeamsNumber(teamsNumber);
        this.isKnockout = isKnockout;
        this.dates = dates;
        initGroups();
    }

    public void initGroups(){
        int teamsPerGroup = 4;
        if (isKnockout){
            teamsPerGroup = 2;
        }
        int groupMatches = teamsPerGroup/teamsNumber;
        for (int i=0; i< groupMatches ; i++){
            groups.add(new Group(isKnockout, dates.subList(i, i+groupMatches ) ));
        }
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
       groups.add(group);
    }

    public void removeGame(Group group){
        groups.remove(group);
    }

    public int getTeamsNumber() {
        return teamsNumber;
    }

    public void setTeamsNumber(int teamsNumber) {
        this.teamsNumber = teamsNumber;
    }


    @Override
    public String toString() {
        return "Round{" +
                "teamsNumber=" + teamsNumber +
                '}';
    }
}
