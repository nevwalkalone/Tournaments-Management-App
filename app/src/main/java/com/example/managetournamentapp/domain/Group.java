package com.example.managetournamentapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {
    private boolean isKnockout;
    private int groupSize;
    private ArrayList<Game> games = new ArrayList<>();
    private Map <Team, Integer> ranking = new HashMap();


    public void addTeam(Team team){
        if (team == null){
            return;
        }
        if (ranking.keySet().size()==groupSize){
            return;
        }
    }



    public Group(boolean isKnockout) {
        this.isKnockout =isKnockout;
        if (isKnockout){
            groupSize = 2;
        }
        else{
            groupSize=4;
        }
    }

    public boolean isKnockout() {
        return isKnockout;
    }

    public void setKnockout(boolean knockout) {
        isKnockout = knockout;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public Map<Team, Integer> getRanking() {
        return ranking;
    }

    public void setRanking(Map<Team, Integer> ranking) {
        this.ranking = ranking;
    }
}
