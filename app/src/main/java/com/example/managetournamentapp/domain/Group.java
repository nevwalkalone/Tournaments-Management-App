package com.example.managetournamentapp.domain;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Group {
    private final boolean isKnockout;
    private final int groupSize;
    private final int gamesNumber;
    private ArrayList<Game> games = new ArrayList<>();
    private Map<Team, Integer> rankings = new HashMap<>();
    private ArrayList<LocalDate> dates;


    public Group(boolean isKnockout , ArrayList<LocalDate> dates ) {
        this.isKnockout = isKnockout;
        this.dates = dates;
        if (isKnockout) {
            groupSize = 2;
            gamesNumber = 1;
        } else {
            //TODO IF PERITTOS ARITHMOS
            groupSize = 4;
            gamesNumber = 6;
        }
    }

    public void addTeam(Team team) {
        if (team == null) {
            return;
        }
        if (rankings.keySet().size() == groupSize) {
            return;
        }
        if (rankings.containsKey(team))
            return;
        rankings.put(team, 0);
    }

    public void addTeams(ArrayList<Team> teams) {
        rankings = new HashMap<>();
        for (Team team: teams){
            addTeam(team);
        }
        setupGames(teams);
    }


    public void setupGames(List<Team> teams){
        games.clear();
        games.add( new Game("",teams.get(0),teams.get(1),dates.get(0)  ));
        if (isKnockout)
            return;
        games.add( new Game("",teams.get(0),teams.get(2),dates.get(1)  ));
        games.add( new Game("",teams.get(0),teams.get(3),dates.get(2)  ));
        games.add( new Game("",teams.get(1),teams.get(2),dates.get(3)  ));
        games.add( new Game("",teams.get(1),teams.get(3),dates.get(4)  ));
        games.add( new Game("",teams.get(2),teams.get(3),dates.get(5)  ));
    }


    public int getTeamRanking(Team team) {
        if (team == null) {
            return -1;
        }
        if (!rankings.containsKey(team)) {
            return -1;
        }
        return rankings.get(team);
    }

    public void increaseTeamRanking(Team team, int points) {
        if (team == null || points < 0) {
            return;
        }
        if (!rankings.containsKey(team)) {
            return;
        }
        rankings.put(team, rankings.get(team) + points);
    }

    public void setRankingsToZero(){
        for (Map.Entry<Team, Integer> entry : rankings.entrySet()) {
            rankings.put(entry.getKey(), 0);
        }
    }

    public void refreshRankings(){
        setRankingsToZero();
        for (Game game : games){
            if (game.isFinished()){
                if (game.findWinner()>0){
                    increaseTeamRanking(game.getTeamA(),3);
                }else if (game.findWinner()<0){
                    increaseTeamRanking(game.getTeamB(),3);
                }else{
                    increaseTeamRanking(game.getTeamA(),1);
                    increaseTeamRanking(game.getTeamB(),1);
                }
            }
        }
    }


    public boolean isKnockout() {
        return isKnockout;
    }

    public ArrayList<Game> getGames() {
        return new ArrayList<>(games);
    }

    public void addGame(Game game) {
        if (game == null) {
            return;
        }
        if (games.size() == groupSize) {
            return;
        }
        if (games.contains(game))
            return;
        games.add(game);
    }

    public Map<Team, Integer> getRankings() {
        return sortByValue(rankings);
    }

    public ArrayList<Team> getTeams() {
        return new ArrayList<Team>(rankings.keySet());
    }

    public boolean allGamesFinished() {
        if (games.isEmpty())
            return false;
        for (Game game : games) {
            if (!game.isFinished())
                return false;
        }
        return true;
    }



    public ArrayList<Team> getGroupWinners() {
        if (!allGamesFinished())
            return null;

        Map<Team, Integer> sortedRankings = sortByValue(rankings);
        ArrayList<Team> winners = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>(sortedRankings.keySet());
        // pick 1 winner
        if (isKnockout()) {
            winners.add(teams.get(1));
        }
        // pick 2 winners
        else {
            winners.add(teams.get(3));
            winners.add(teams.get(2));
        }
        return winners;
    }



    // function to sort hashmap by values
    private static Map<Team, Integer> sortByValue(Map<Team, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Team, Integer>> list =
                new LinkedList<Map.Entry<Team, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Team, Integer>>() {
            public int compare(Map.Entry<Team, Integer> o1,
                               Map.Entry<Team, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Team, Integer> temp = new LinkedHashMap<Team, Integer>();
        for (Map.Entry<Team, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }




    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if (other instanceof Group) {
            Group otherGroup = (Group) other;
            if (gamesNumber == otherGroup.gamesNumber && isKnockout == otherGroup.isKnockout
                    && groupSize == otherGroup.groupSize && rankings.equals(otherGroup.rankings)
                    && games.equals(otherGroup.games) && dates.equals(otherGroup.dates))
                return true;
        }
        return false;
    }


}
