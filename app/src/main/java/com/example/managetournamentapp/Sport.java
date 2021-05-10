package com.example.managetournamentapp;


public class Sport {

    private String name;
    private int minimumPlayers, gameDuration;

    public Sport(String name, int minimumPlayers, int gameDuration) {
        this.name = name;
        this.minimumPlayers = minimumPlayers;
        this.gameDuration = gameDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(int minimumPlayers) {
        this.minimumPlayers = minimumPlayers;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", minimumPlayers=" + minimumPlayers +
                ", gameDuration=" + gameDuration +
                '}';
    }
}
