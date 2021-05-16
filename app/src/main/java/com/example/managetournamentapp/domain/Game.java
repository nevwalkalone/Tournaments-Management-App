package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;

public class Game {

    private String arena;
    private int scoreA, scoreB;
    private Team teamA, teamB;
    private LocalDate date;
    private boolean isFinished;

    public Game(){
    }

    public Game(String arena, Team teamA, Team teamB, LocalDate date) {
        this.arena = arena;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        isFinished = false;
    }

    //constructor initialized before the tournament starts
    public Game(LocalDate date) {
        this.date = date;
        isFinished = false;
    }

    public int findWinner() {
        if(!isFinished())
            return 2;       // random number ( different from Integer.compare method -1, 0, 1 ) 
                            // in order to handle the state of the game.
        return Integer.compare(scoreA, scoreB);
    }


    public String getArena() {
        return arena;
    }

    public void setArena(String area) {
        this.arena = area;
    }


    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public boolean equals(Object other) {
        boolean equal = false;
        if (other instanceof Game) {
            Game otherGame = (Game) other;
            if (teamA.equals(otherGame.teamA) && teamB.equals(otherGame.teamB) && scoreA==otherGame.scoreA
                    && scoreB==otherGame.scoreB && arena.equals(otherGame.arena)
                        && isFinished==otherGame.isFinished && date.equals(otherGame.getDate()) )
                equal = true;
        }
        return equal;
    }


    @Override
    public String toString() {
        return "Game{" +
                "arena='" + arena + '\'' +
                ", scoreA=" + scoreA +
                ", scoreB=" + scoreB +
//                ", teamA=" + teamA +
//                ", teamB=" + teamB +
                ", date=" + date +
                ", isFinished=" + isFinished +
                '}';
    }
}
