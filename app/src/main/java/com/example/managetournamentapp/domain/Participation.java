package com.example.managetournamentapp.domain;

import android.os.Build;

import androidx.annotation.RequiresApi;

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


    public boolean isPast(){

        return finishDate.isBefore(LocalDate.now()) ;
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

    public boolean isSimultaneous(Participation other){
        if (other == null)
            return false;

        if ( startDate.equals(other.startDate) && tournament.equals(other.tournament) )
            return true;

        return  false;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
