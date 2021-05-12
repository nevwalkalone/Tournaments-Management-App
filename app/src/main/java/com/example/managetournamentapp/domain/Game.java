package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;

public class Game {

    private String arena;
    private int scoreA, scoreB;
    private Team teamA, teamB;
    private LocalDate date;
    private LocalDateTime time;


    public Game(String arena, Team teamA, Team teamB, LocalDate date, LocalDateTime time) {
        this.arena = arena;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.time = time;
    }

    //constructor initialized before the tournament starts
    public Game(LocalDate date, LocalDateTime time) {
        this.date = date;
        this.time = time;
    }

    public int findResult(){
        return Integer.compare(scoreA, scoreB);
    }


    public String getArena() {
        return arena;
    }

    public void setArena(String area) {
        this.arena = area;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Game{" +
                "area='" + arena + '\'' +
                ", result='" + '\'' +
                ", scoreA=" + scoreA +
                ", scoreB=" + scoreB +
                ", teamA=" + teamA +
                ", teamB=" + teamB +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
