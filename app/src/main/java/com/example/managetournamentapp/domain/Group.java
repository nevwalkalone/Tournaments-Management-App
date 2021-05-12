package com.example.managetournamentapp.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Group {
    private boolean isKnockout;
    private int groupSize;
    private int gamesNumber;
    private ArrayList<Game> games = new ArrayList<>();
    private Map<Team, Integer> rankings = new HashMap<>();

    //TODO CHECK BASKET OR FOOTBALL!!!

    public Group(boolean isKnockout) {
        this.isKnockout = isKnockout;
        if (isKnockout) {
            groupSize = 2;
            gamesNumber = 1;
        } else {
            //TODO IF PERITOS ARITHMOS
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

    public void removeTeam(Team team) {
        if (team == null) {
            return;
        }
        if (!rankings.containsKey(team)) {
            return;
        }
        rankings.remove(team);
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

    public void updateTeamRanking(Team team, int points) {
        if (team == null || points < 0) {
            return;
        }
        if (!rankings.containsKey(team)) {
            return;
        }
        rankings.put(team, rankings.get(team) + points);
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

    public void removeGame(Game game) {
        if (game == null) {
            return;
        }
        if (!games.contains(game))
            return;
        //TODO CHECK IF GAME IS FINISHED!!!!
        games.remove(game);
    }

    public Map<Team, Integer> getRankings() {
        return rankings;
    }

    public boolean groupGamesFinished() {
        int counter = 0;
        for (Game game : games) {
            if (game.isFinished())
                counter++;
        }
        return gamesNumber >= counter;
    }

    // TODO CHANGE NAME FOR THIS METHOD!!!
    // function to sort hashmap by values
    public static Map<Team, Integer> sortByValue(Map<Team, Integer> hm) {
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


    public ArrayList<Team> getGroupWinners() {
        if (!groupGamesFinished())
            return null;

        Map<Team, Integer> sortedRankings = sortByValue(rankings);
        ArrayList<Team> winners = new ArrayList<>();

        ArrayList<Team> teams = new ArrayList<>();
        // pick 1 winner
        if (isKnockout()) {
            teams.addAll(sortedRankings.keySet());
            winners.add(teams.get(teams.size() - 1));


        }
        // pick 2 winners
        else {
            teams.addAll(sortedRankings.keySet());
            winners.add(teams.get(teams.size() - 1));
            winners.add(teams.get(teams.size() - 2));
        }
        return winners;
    }


}
