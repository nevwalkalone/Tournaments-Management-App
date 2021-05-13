package com.example.managetournamentapp.domain;

import java.util.ArrayList;

public class Team {
    private String name, colors;
    private Sport sportType;
    private boolean isOccupied = false;
    private AgeDivision ageDivision;
    private Player captain;
    private  ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Participation> participations = new ArrayList<>();

    public Team(){

    }

    public Team(String name, String colors, Sport sportType, AgeDivision ageDivision, Player captain, int playersNumber) {
        this.name = name;
        this.sportType = sportType;
        this.ageDivision = ageDivision;
        this.captain = captain;
        //add captain to the team
        this.players.add(captain);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setParticipations(ArrayList<Participation> participations) {
        this.participations = participations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Sport getSportType() {
        return sportType;
    }

    public void setSportType(Sport sportType) {
        this.sportType = sportType;
    }

    public AgeDivision getAgeDivision() {
        return ageDivision;
    }

    public void setAgeDivision(AgeDivision ageDivision) {
        this.ageDivision = ageDivision;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }


    public void addPlayer(Player player) {
        if (player == null){
            return;
        }
        //TODO check if team is occupied
        if (isOccupied){
            return;
        }
        if (players.contains(player)){
            return;
        }

        if (player.canJoin(this)){
            //if (getCaptain().equals(player)){
               // captainInTeams.add(team);
           // }
            //add player to the team
            players.add(player);

            //add team to the player
            player.addJoinedTeam(this);

        }



    }


    public void addParticipation(Participation participation) {
        if (participation == null){
            return;
        }
        if (participations.contains(participation)){
            return;
        }

        if (canParticipate(participation)){
            participations.add(participation);
        }
    }

    public void removeParticipation(Participation participation) {

    }


    public boolean canParticipate(Participation participation) {
        Tournament tournToJoin = participation.getTournament();

        if (!getAgeDivision().equals(tournToJoin.getAgeDivision())) {

            return false;
        }

        if (!tournToJoin.getSportType().equals(sportType)) {
            return false;
        }

        if (tournToJoin.isFull()){
            return false;
        }

        if (players.size() < ( sportType.getMinimumPlayers()/2)){
            return false;
        }

        for (Player player : players){
            for (Participation playerPart : player.getRunningParticipations()) {
                if (playerPart.isSimultaneous(participation)){
                    return false;
                }
            }
        }


        return true;
    }

    public ArrayList<Participation> getParticipations() {
        return participations;
    }

    public ArrayList<Participation> getRunningParticipations() {
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Participation p : participations) {
            if (!p.isPast())
                runningParticipations.add(p);
        }
        return runningParticipations;
    }


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", colors='" + colors + '\'' +
                ", sportType=" + sportType +
                ", ageDivision=" + ageDivision +
                ", captain=" + captain +
                ", playersNumber=" +
                '}';
    }


    public boolean equals(Object other) {

        boolean equal = false;
        if (other instanceof Team) {
            Team otherTeam = (Team) other;
            if (name.equals(otherTeam.name) && sportType.equals(otherTeam.sportType))
                equal = true;
        }
        return equal;
    }

}
