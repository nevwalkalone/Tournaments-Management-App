package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Organizer extends User {

    private String title;
    private ArrayList<Tournament> tournaments = new ArrayList<>();

    public Organizer() {
        super();
        this.title = "";
    }

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

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }


    public void addTournament(Tournament tour) {
        if (tour == null) {
            return;
        }
        if (!tournaments.contains(tour)) {
            tournaments.add(tour);
        }
    }

    public void deleteTournament(Tournament tour) {
        if (tour == null) {
            return;
        }
        if (!tournaments.contains(tour)) {
            return;
        }

        if (tour.isRunning()) {
            return;
        }

        ArrayList<Participation> participations = tour.getParticipations();
        //TODO CONCURRENT MODIFICATION
        for (Participation participation : participations) {

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

    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null)
            return false;

        boolean equal = false;
        if (other instanceof Organizer) {
            Organizer otherOrganizer = (Organizer) other;
            if (title.equals(otherOrganizer.title) && otherOrganizer.title != null)         // each Organizer has a unique Title. EK15!
                equal = true;
        }
        return equal;
    }
}
