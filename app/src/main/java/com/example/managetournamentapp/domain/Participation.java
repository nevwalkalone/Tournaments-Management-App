package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.*;

public class Participation {
    private LocalDate startDate, finishDate;
    private Tournament tournament;
    private Team team;



    public Participation(LocalDate startDate, LocalDate finishDate) {
        this.startDate = startDate;
        this.finishDate = finishDate;
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
    @Override
    public String toString() {
        return "Participation{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
