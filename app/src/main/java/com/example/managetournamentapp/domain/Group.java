package com.example.managetournamentapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {
    private boolean isKnockout;
    private int groupSize;
    private int gamesNumber;
    private ArrayList<Game> games = new ArrayList<>();
    private Map <Team, Integer> rankings = new HashMap();

    public Group(boolean isKnockout) {
        this.isKnockout =isKnockout;
        if (isKnockout){
            groupSize = 2;
            gamesNumber = 1;
        }else{
            groupSize = 4;
            gamesNumber = 6;
        }
    }



    public void addTeam(Team team){
        if (team == null){
            return;
        }
        if (rankings.keySet().size()==groupSize){
            return;
        }
        if ( rankings.containsKey(team) )
            return;
        rankings.put(team, 0);
    }

    public void removeTeam(Team team){
        if (team == null){
            return;
        }
        if ( !rankings.containsKey(team) ) {
            return;
        }
        rankings.remove(team);
    }



    public int getTeamRanking(Team team){
        if (team == null){
            return -1;
        }
        if ( !rankings.containsKey(team) ) {
            return -1;
        }
        return rankings.get(team);
    }

    public void setTeamRanking(Team team , int rank){
        if (team == null || rank<0 ){
            return ;
        }
        if ( !rankings.containsKey(team) ) {
            return ;
        }
        rankings.put(team, rank);
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

    public void addGame(Game game) {
        if (game == null){
            return;
        }
        if (games.size()==groupSize){
            return;
        }
        if ( games.contains(game) )
            return;
        games.add(game);
    }

    public void removeGame(Game game) {
        if (game == null){
            return;
        }
        if ( !games.contains(game) )
            return;
        games.remove(game);
    }

    public Map<Team, Integer> getRankings() {
        return rankings;
    }

}
