package com.example.managetournamentapp.domain;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.*;

public class Participation {

    private LocalDate startDate, finishDate;
    private Tournament tournament;
    private Team team;


    public Participation(){

    }

    public Participation(Tournament tournament, Team team) {
            this.tournament = tournament;
            this.team = team;
            this.startDate = tournament.getStartDate();

    }

    public Tournament getTournament() {
        return tournament;
    }


    public Team getTeam() {
        return team;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }


    public boolean isPast() {

        return finishDate.isBefore(LocalDate.now());
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isSimultaneous(Participation other) {
        if (other == null)
            return false;

        return tournament.equals(other.tournament);

    }

    @Override
    public String toString() {
        return "Participation{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
