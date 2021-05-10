package com.example.managetournamentapp;

public class Team {
    private String name,colors;
    private Sport sportType;
    private AgeDivision ageDivision;
    private Player captain;
    private int playersNumber;

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
}
