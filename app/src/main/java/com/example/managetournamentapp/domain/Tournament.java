package com.example.managetournamentapp.domain;

import android.provider.Telephony;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tournament {

    private final int MAXTEAMSNUMBER;
    private String title, location, description;
    private Sport sportType;
    private ArrayList<Round> rounds = new ArrayList<>();
    private ArrayList<Participation> participations;
    private AgeDivision ageDivision;
    private LocalDate startDate;

    private LocalDate finishDate;

    public Tournament(){
        MAXTEAMSNUMBER = 32;
    }

    public Tournament(String title, String location, String description, Sport sportType, int maxTeamsNumber, AgeDivision ageDivision) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.sportType = sportType;
        this.MAXTEAMSNUMBER = maxTeamsNumber;
        this.ageDivision = ageDivision;
    }

    public void addParticipation(Participation participation){

        participations.add(participation);
    }

    //check if tournament is full of teams
    public boolean isFull(){
        return participations.size() == MAXTEAMSNUMBER;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
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
                ", roundsNumber=" +
                ", teams=" + teams +
                ", ageDivision=" + ageDivision +
                '}';
    }
}
