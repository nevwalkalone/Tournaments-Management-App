package com.example.managetournamentapp.domain;

public class Organizer extends User{

    private String title, sportType;

    public Organizer(String title, String sportType) {
        this.title = title;
        this.sportType = sportType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }


    public void createTournament(){

    }

    public void deleteTournament(Tournament tour){

    }

    public void createRounds(Tournament tour){

    }

    public void setDates(Tournament tour){

    }

    public void editTournamentData(Tournament tour){

    }

    public void uploadResults(Tournament tour){

    }


    @Override
    public String toString() {
        return "Organizer{" +
                "title='" + title + '\'' +
                ", sportType='" + sportType + '\'' +
                '}';
    }
}
