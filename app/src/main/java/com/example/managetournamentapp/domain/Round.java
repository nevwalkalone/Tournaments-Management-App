package com.example.managetournamentapp.domain;

import java.util.*;
public class Round {

    private int teamsNumber, gamesNumber;
    private Date startDate, finishDate;
    private ArrayList<Group> groups = new ArrayList<>();


    public Round(){

    }

    public Round(int teamsNumber, int gamesNumber, Date startDate, Date finishDate) {
        setTeamsNumber(teamsNumber);
        setGamesNumber(gamesNumber);
        setStartDate(startDate);
        setFinishDate(finishDate);
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

    public int getGamesNumber() {
        return gamesNumber;
    }

    public void setGamesNumber(int gamesNumber) {
        this.gamesNumber = gamesNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    

    @Override
    public String toString() {
        return "Round{" +
                "teamsNumber=" + teamsNumber +
                ", gamesNumber=" + gamesNumber +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
