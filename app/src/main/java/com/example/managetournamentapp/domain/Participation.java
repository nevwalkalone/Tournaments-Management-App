package com.example.managetournamentapp.domain;


import java.time.LocalDate;


public class Participation {

    private LocalDate startDate, finishDate;
    private Tournament tournament;
    private Team team;


    public Participation() {

    }

    public Participation(Tournament tournament, Team team) {
        this.tournament = tournament;
        this.team = team;
        this.startDate = tournament.getStartDate();
        this.finishDate = tournament.getFinishDate();           // First initialization. We don't know when our team will finish.

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

    public boolean inSameTournament(Participation other) {  // may need a check for dates
        if (other == null)
            return false;
        return tournament.equals(other.tournament);
    }

    public boolean isSimultaneous(Participation other) {  // check for null finish dates TODO
        if (startDate.isBefore(other.getStartDate()) && finishDate.isBefore(other.getStartDate())) {
            return false;
        }
        if (startDate.isAfter(other.getFinishDate()) && finishDate.isAfter(other.getFinishDate())) {
            return false;
        }
        return true;
    }

    public boolean isCurrent() {
        if (finishDate == null) {
            return startDate.isBefore(LocalDate.now());
        } else {
            return startDate.isBefore(LocalDate.now()) && finishDate.isAfter(LocalDate.now());
        }
    }


    @Override
    public String toString() {
        return "Participation{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
