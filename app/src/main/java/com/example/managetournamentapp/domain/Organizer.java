package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Organizer extends User {

    private String title;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    public Organizer(String name, String surname, String phoneNumber, String email, LocalDate birthDate, Credentials credentials, String title) {
        super(name, surname, phoneNumber, email, birthDate, credentials);
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void changeTournamentTitle(Tournament tournament, String title){
        if (tournament == null || title == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.isRunning()){
            return;
        }
        tournament.setTitle(title);
    }

    public void changeTournamentLocation(Tournament tournament, String location){
        if (tournament == null || location == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.getParticipations().isEmpty()){
            return;
        }
        tournament.setLocation(location);
    }

    public void changeTournamentDescription(Tournament tournament, String description){
        if (tournament == null || description == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.isRunning()){
            return;
        }
        tournament.setDescription(description);
    }

    public void changeTournamentSport(Tournament tournament, Sport sportType){
        if (tournament == null || sportType == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.getParticipations().isEmpty()){
            return;
        }
        tournament.setSportType(sportType);
    }

    public void changeTournamentAgeDivision(Tournament tournament, AgeDivision ageDivision){
        if (tournament == null || ageDivision == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.getParticipations().isEmpty()){
            return;
        }
        tournament.setAgeDivision(ageDivision);
    }

    public void changeStartDate(Tournament tournament, LocalDate startDate){
        if (tournament == null || startDate == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.getParticipations().isEmpty()){
            return;
        }
        tournament.setStartDate(startDate);
    }

    public void changeFinishDate(Tournament tournament, LocalDate startDate){
        if (tournament == null || startDate == null ){
            return;
        }
        if (!tournaments.contains(tournament)){
            return;
        }
        if (tournament.getParticipations().isEmpty()){
            return;
        }
        tournament.setFinishDate(startDate);
    }

    public void addTournament(Tournament tour) {
        if (tour == null){
            return;
        }
        if (!tournaments.contains(tour)){
            tournaments.add(tour);
        }
    }

    public void deleteTournament(Tournament tour) {
        if (tour == null){
            return;
        }
        if (!tournaments.contains(tour)){
            return;
        }

        if (tour.isRunning()){
            return;
        }

        ArrayList<Participation> participations = tour.getParticipations();
        for (Participation participation : participations){
            Team team = participation.getTeam();
            team.removeParticipation(participation);
        }
        tournaments.remove(tour);
    }



    @Override
    public String toString() {
        return "Organizer{" +
                "title='" + title + '\'' +
                ", sportType='" + '\'' +
                '}';
    }
}
