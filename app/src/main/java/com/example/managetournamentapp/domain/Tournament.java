package com.example.managetournamentapp.domain;


import java.time.LocalDate;
import java.util.ArrayList;

public class Tournament {

    private final int MAX_TEAMS_NUMBER;
    private LocalDate startDate, finishDate;
    private String title, location, description;
    private Sport sportType;
    private ArrayList<Round> rounds = new ArrayList<>();
    private ArrayList<LocalDate> dates;
    private ArrayList<Participation> participations = new ArrayList<>();
    private AgeDivision ageDivision;

    public Tournament() {
        MAX_TEAMS_NUMBER = 32;
    }

    public Tournament(String title, LocalDate startDate, LocalDate finishDate, String location, Sport sportType, int maxTeamsNumber, AgeDivision ageDivision , ArrayList<LocalDate> dates) {
        this.title = title;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.location = location;
        this.sportType = sportType;
        this.MAX_TEAMS_NUMBER = maxTeamsNumber;
        this.ageDivision = ageDivision;
        initRounds(dates);
    }

    public void initRounds(ArrayList<LocalDate> dates ){      //TODO dates = 2*maxteams - 1
        int teamsNumber = MAX_TEAMS_NUMBER;
        int firstIndex = 0;
        int lastIndex = MAX_TEAMS_NUMBER/4 * 6;
        rounds.add( new Round(MAX_TEAMS_NUMBER, false, dates.subList(firstIndex,lastIndex) ));
        for( int i=0 ; i < log2(MAX_TEAMS_NUMBER)-1; i++ ){
            teamsNumber = teamsNumber/2;
            firstIndex = lastIndex;
            lastIndex = firstIndex+ teamsNumber/2;
            rounds.add( new Round(teamsNumber, true, dates.subList(firstIndex,lastIndex) ));
        }
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

    public boolean isRunning(){
        LocalDate now = LocalDate.now();
        return !(now.isBefore(startDate)) && !(now.isAfter(finishDate));
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public ArrayList<Participation> getParticipations() {
        return participations;
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

    public int getMAX_TEAMS_NUMBER() {
        return MAX_TEAMS_NUMBER;
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

    public static int log2(int x){
        return (int) ( Math.log(x) / Math.log(2)  );
    }

    public boolean equals(Object other) {

        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        boolean equal = false;
        if (other instanceof Tournament) {
            Tournament otherTour = (Tournament) other;

            if ((title.equals(otherTour.title) && otherTour.title != null) &&
                    (startDate.equals(otherTour.startDate) && otherTour.startDate != null) &&
                    (finishDate.equals(otherTour.finishDate) && otherTour.finishDate != null) &&
                    (location.equals(otherTour.location) && otherTour.location != null) &&
                    (sportType.equals(otherTour.sportType) && otherTour.sportType != null) &&
                    (ageDivision.equals(otherTour.ageDivision) && otherTour.ageDivision != null) &&
                    (dates.equals(otherTour.dates) && otherTour.dates != null) &&
                    getMAX_TEAMS_NUMBER() == otherTour.getMAX_TEAMS_NUMBER())

                equal = true;
        }
        return equal;
    }

}
