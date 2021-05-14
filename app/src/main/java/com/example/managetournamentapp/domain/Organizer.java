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

        if (!tour.isRunning()){
            ArrayList<Participation> participations = tour.getParticipations();
            for (Participation part : participations){
                Team team = part.getTeam();
                team.removeParticipation(part);
            }
        }
    }



    @Override
    public String toString() {
        return "Organizer{" +
                "title='" + title + '\'' +
                ", sportType='" + '\'' +
                '}';
    }
}
