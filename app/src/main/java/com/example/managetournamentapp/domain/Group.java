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
    private List<LocalDate> dates;


    public Group(boolean isKnockout ,List<LocalDate> dates ) {
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

        if (game.isFinished())
            return;

        games.remove(game);
    }

    public Map<Team, Integer> getRankings() {
        return rankings;
    }

    public ArrayList<Team> getTeams() {
        return new ArrayList<Team>(rankings.keySet());
    }

    public boolean allGamesFinished() {
        for (Game game : games) {
            if (!game.isFinished())
                return false;
        }
        return true;
    }


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



}
