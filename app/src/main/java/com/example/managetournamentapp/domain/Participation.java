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

    public boolean isSimultaneous(Participation other) {  // check for null finish dates
        if (finishDate.isBefore(other.getStartDate()) || other.getFinishDate().isBefore(startDate)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        LocalDate now = LocalDate.now();
        return !(now.isBefore(startDate)) && !(now.isAfter(finishDate));
    }


    @Override
    public String toString() {
        return "Participation{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }



    public boolean equals(Object other){

        if (other == null) {
            return false;
        }
        if (!(other instanceof Participation)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        Participation check = (Participation) other;

        if (!(team == null ? check.getTeam()
                == null : team.equals(check.getTeam()))) {
            return false;
        }

        if (!(tournament == null ? check.getTournament()
                == null : tournament.equals(check.getTournament()))) {
            return false;
        }


        return true;

    }
}
