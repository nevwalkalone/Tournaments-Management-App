package com.example.managetournamentapp.domain;

import java.util.ArrayList;

public class Team {
    private String name,colors;
    private Sport sportType;
    private AgeDivision ageDivision;
    private Player captain;
    private int playersNumber;
    private ArrayList<Participation> participations = new ArrayList<>();

    public Team(String name, String colors, Sport sportType, AgeDivision ageDivision, Player captain, int playersNumber) {
        this.name = name;
        this.colors = colors;
        this.sportType = sportType;
        this.ageDivision = ageDivision;
        this.captain = captain;
        this.playersNumber = playersNumber;
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

    public int getPlayersNumber() {
        return playersNumber;
    }

    public void setPlayersNumber(int playersNumber) {
        this.playersNumber = playersNumber;
    }

    public void addParticipation(Participation participation){

    }

    public void removeParticipation(Participation participation){

    }

    public ArrayList<Participation> getParticipations(){
        return participations;
    }

    public ArrayList<Participation> getRunningParticipations(){
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Participation p: participations){
            if (! p.isPast())
                runningParticipations.add(p);
        }
        return  runningParticipations;
    }


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", colors='" + colors + '\'' +
                ", sportType=" + sportType +
                ", ageDivision=" + ageDivision +
                ", captain=" + captain +
                ", playersNumber=" + playersNumber +
                '}';
    }


    public boolean equals(Object other){
        boolean equal = false;
        if ( other instanceof Team ){
            Team otherTeam = (Team) other;
            if ( name.equals(otherTeam.name) && sportType.equals(otherTeam.sportType) )
                equal = true;
        }
        return equal;
    }

}
