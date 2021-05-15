package com.example.managetournamentapp.domain;

import java.time.LocalDate;

public class Invitation {
    private Team team;
    private boolean pending,accepted=false;
    private LocalDate date;

    public Invitation(Team team){
        this.team = team;
        this.pending = false;
        date = LocalDate.now();
    }

    public boolean getPending() {
        return pending;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        if (pending){
            this.team = team;
            this.accepted = accepted;
            pending = false;
        }
    }

    public LocalDate detDate() {
        return date;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public boolean equals(Object other) {
        boolean equal = false;
        if (other instanceof Invitation) {
            Invitation otherInvite = (Invitation) other;
            if (team.equals(otherInvite.team) && date.equals(otherInvite.date)) {
                equal = true;
            }
        }
        return equal;
    }



}
