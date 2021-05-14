package com.example.managetournamentapp.domain;


import java.time.LocalDate;
import java.util.ArrayList;

public class Tournament {

    private final int MAX_TEAMS_NUMBER;
    private LocalDate startDate, finishDate;
    private String title, location, description;
    private Sport sportType;
    private ArrayList<Round> rounds = new ArrayList<>();


    private ArrayList<Participation> participations;
    private AgeDivision ageDivision;


    public Tournament() {
        MAX_TEAMS_NUMBER = 32;
    }

    public Tournament(String title, LocalDate startDate, LocalDate finishDate, String location, Sport sportType, int maxTeamsNumber, AgeDivision ageDivision) {
        this.title = title;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.location = location;
        this.sportType = sportType;
        this.MAX_TEAMS_NUMBER = maxTeamsNumber;
        this.ageDivision = ageDivision;
    }

    public void addParticipation(Participation participation) {

        participations.add(participation);
    }

    public void removeParticipation(Participation participation) {
        participations.remove(participation);
    }

    //check if tournament is full of teams
    public boolean isFull() {
        return participations.size() == MAX_TEAMS_NUMBER;
    }

    public boolean isFinished() {
        LocalDate now = LocalDate.now();
        if (now.compareTo(getFinishDate()) > 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public ArrayList<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(ArrayList<Participation> participations) {
        this.participations = participations;
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


    public AgeDivision getAgeDivision() {
        return ageDivision;
    }

    public void setAgeDivision(AgeDivision ageDivision) {
        this.ageDivision = ageDivision;
    }

    public void manageRequests(Team team, boolean accept) {

    }

    @Override
    public String toString() {
        return "Tournament{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", sportType=" + sportType +
                ", maxTeamsNumber=" +
                ", roundsNumber=" +
                ", teams=" +
                ", ageDivision=" + ageDivision +
                '}';
    }
}
