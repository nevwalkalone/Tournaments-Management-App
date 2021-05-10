package com.example.managetournamentapp;

import java.util.ArrayList;

public class Tournament {

    private String title, location, description;
    private Sport sportType;
    private int maxTeamsNumber, roundsNumber;
    private ArrayList<Team> teams;
    private AgeDivision ageDivision;

    public Tournament(String title, String location, String description, Sport sportType, int maxTeamsNumber, int roundsNumber, ArrayList<Team> teams, AgeDivision ageDivision) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.sportType = sportType;
        this.maxTeamsNumber = maxTeamsNumber;
        this.roundsNumber = roundsNumber;
        this.teams = teams;
        this.ageDivision = ageDivision;
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public void removeTeam(Team team){
        teams.remove(team);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sport getSportType() {
        return sportType;
    }

    public void setSportType(Sport sportType) {
        this.sportType = sportType;
    }

    public int getMaxTeamsNumber() {
        return maxTeamsNumber;
    }

    public void setMaxTeamsNumber(int maxTeamsNumber) {
        this.maxTeamsNumber = maxTeamsNumber;
    }

    public int getRoundsNumber() {
        return roundsNumber;
    }

    public void setRoundsNumber(int roundsNumber) {
        this.roundsNumber = roundsNumber;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public AgeDivision getAgeDivision() {
        return ageDivision;
    }

    public void setAgeDivision(AgeDivision ageDivision) {
        this.ageDivision = ageDivision;
    }

    public void manageRequests(Team team, boolean accept){

    }

    @Override
    public String toString() {
        return "Tournament{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", sportType=" + sportType +
                ", maxTeamsNumber=" + maxTeamsNumber +
                ", roundsNumber=" + roundsNumber +
                ", teams=" + teams +
                ", ageDivision=" + ageDivision +
                '}';
    }
}
