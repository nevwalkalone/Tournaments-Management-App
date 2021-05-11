package com.example.managetournamentapp.domain;

import com.example.managetournamentapp.domain.Team;

import java.util.*;
import java.time.LocalDateTime;

public class Game {

    private String area, result;
    private int scoreA, scoreB;
    private Team teamA, teamB;
    private Date date;
    private LocalDateTime time;

    public Game(String area, String result, int scoreA, int scoreB, Team teamA, Team teamB, Date date, LocalDateTime time) {
        this.area = area;
        this.result = result;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.time = time;
    }

    public Team getWinner(){
        if (scoreA>scoreB)
            return teamA;
        return teamB;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                "area='" + area + '\'' +
                ", result='" + result + '\'' +
                ", scoreA=" + scoreA +
                ", scoreB=" + scoreB +
                ", teamA=" + teamA +
                ", teamB=" + teamB +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
