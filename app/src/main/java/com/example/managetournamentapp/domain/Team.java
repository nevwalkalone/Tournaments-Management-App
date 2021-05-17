package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;


public class Team {

    private String name, colors;
    private Sport sportType;
    private AgeDivision ageDivision;
    private Player captain;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Participation> participations = new ArrayList<>();

    public Team() {
    }

    public Team(String name, Sport sportType, AgeDivision ageDivision, Player captain, String colors) {
        this.name = name;
        this.sportType = sportType;
        this.ageDivision = ageDivision;
        this.colors = colors;
        this.captain = captain;
        addPlayer(captain);
    }

    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    protected ArrayList<Player> friendGetPlayers(){
        return players;
    }

    //checks are made on player class
    public void addPlayer(Player player) {
        if (player == null) {
            return;
        }
        player.addJoinedTeam(this);
    }

    public void removePlayer(Player player) {
        if (player == null) {
            return;
        }
        player.removeJoinedTeam(this);
    }



    public boolean hasAnyActivePart() {
        //check if there is any running participation
        for (Participation participation : participations) {
            if (participation.getStartDate().isBefore(LocalDate.now()) && participation.getFinishDate().isAfter(LocalDate.now())) {
                return true;
            }
        }
        return false;                       //player can be successfully removed
    }                                       //because there is no active tournament
    //for his team


    public void setCaptain(Player player) {
        if (player == null) {
            return;
        }
        captain.removeCaptainInTeams(this);
        player.addCaptainInTeams(this);
        captain = player;
    }

    public Player getCaptain() {
        return captain;
    }

    public void invitePlayer(Player player) {
        if (player == null || players.contains(player)) {
            return;
        }
        if (!player.canJoin(this)) {
            return;
        }
        player.addInvite(new Invitation(this));
    }


    public void addParticipation(Participation participation) {
        if (participation == null) {
            return;
        }
        if (participations.contains(participation)) {
            return;
        }
        if (canParticipate(participation)) {
            participations.add(participation);
            participation.getTournament().getParticipations().add(participation);
            participation.getTournament().friendGetParticipations().add(participation);
        }
    }

    //we need the tournament to remove the appropriate participation
    //linked with the tournament TODO IF TOURN IS RUNNING
    public void removeParticipation(Participation participation) {
        if (participation == null) {
            return;
        }
        if (!participations.contains(participation)) {
            return;
        }
        participations.remove(participation);
        participation.getTournament().friendGetParticipations().remove(participation);
    }


    //if all criterias are met, then this team
    //can join the specific tournament TODO CHECK
    public boolean canParticipate(Participation participation) {
        Tournament tournToJoin = participation.getTournament();

        if (!getAgeDivision().equals(tournToJoin.getAgeDivision())) {
            return false;
        }
        if (hasAnyActivePart()) {
            return false;
        }

        if (!tournToJoin.getSportType().equals(sportType)) {
            return false;
        }

        if (tournToJoin.isFull()) {
            return false;
        }


        if (players.size() < (sportType.getMinimumPlayers() / 2)) {
            return false;
        }

        //if there is a player that participates in the specific tournament
        //with another team, then this team can't join the tournament
        for (Player player : players) {
            for (Participation playerPart : player.getUndoneParticipations()) {
                if (playerPart.inSameTournament(participation)) {
                    return false;
                }
            }
        }

        for (Participation part : participations) {
            if (participation.isSimultaneous(part))
                return false;
        }
        return true;
    }


    public ArrayList<Participation> getParticipations() {
        return new ArrayList<>(participations);
    }

    public ArrayList<Participation> getUndoneParticipations() {
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Participation p : participations) {
            if (!p.isPast())
                runningParticipations.add(p);
        }
        return runningParticipations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || !getUndoneParticipations().isEmpty()) {
            return;
        }
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        if (colors == null || !getUndoneParticipations().isEmpty()) {
            return;
        }
        this.colors = colors;
    }

    public Sport getSportType() {
        return sportType;
    }


    public AgeDivision getAgeDivision() {
        return ageDivision;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", sportType=" + sportType +
                ", ageDivision=" + ageDivision +
                '}';
    }


    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if (other instanceof Team) {
            Team otherTeam = (Team) other;
            if (name.equals(otherTeam.name) &&
                    sportType.equals(otherTeam.sportType)
                    && colors.equals(otherTeam.colors)
                    && players.equals(otherTeam.players)
                    && ageDivision.equals(otherTeam.getAgeDivision())
                    && captain.equals(otherTeam.captain)
                    && participations.equals(otherTeam.participations))
                return true;
        }
        return false;
    }

}
