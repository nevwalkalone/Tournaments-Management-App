package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupTest {
    ArrayList<LocalDate> dates;
    Team teamA , teamB;
    Group group;
    Game game;
    Player player;
    LocalDate date;
    @Before
    public void setUp() throws Exception {
        Credentials credentials = new Credentials("sakis7","123");
        dates = new ArrayList<>();
        dates.add(LocalDate.parse("2020-10-10"));
        group = new Group(true, dates);
        player = new Player( "sakis", "rouvas" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        date = LocalDate.parse("2022-01-01");
        teamA = new Team("Celtic", new Sport("Volleyball3v3"), AgeDivision.K12 ,player );
        teamB = new Team("Barca", new Sport("Volleyball3v3"), AgeDivision.K12 ,player );
        game = new Game("Oaka", teamA , teamB, date );
    }


    @Test
    public void addAndRemoveTeams()  {
        group.addTeam(teamA);
        group.addTeam(teamB);
        Assert.assertEquals(group.getTeams().size() , 2);
        group.addTeam(new Team());
        Assert.assertEquals(group.getTeams().size() , 2);
        group.removeTeam(teamA);
        group.removeTeam(teamB);
        Assert.assertEquals(group.getTeams().size() , 0);
    }

    @Test
    public void addAndRemoveGames()  {
        game.setFinished(true);
        group.addGame(game);
        Assert.assertEquals(group.getGames().size() , 1);
        Assert.assertTrue(group.allGamesFinished());

        game.setFinished(false);
        Assert.assertFalse(group.allGamesFinished());
        group.removeGame(game);
        Assert.assertEquals(group.getGames().size() , 0);
    }


    @Test
    public void testRankings()  {
        game.setScoreA(2);
        game.setScoreB(0);
        game.setFinished(true);
        group.addTeam(teamA);
        group.addTeam(teamB);
        group.updateTeamRanking(teamA,3);
        group.addGame(game);
        Assert.assertEquals(group.getGroupWinners().get(0) , teamA);

        Map<Team, Integer> rankings = new HashMap<>();
        rankings.put(teamA,3);
        rankings.put(teamB,0);
        Assert.assertEquals(group.getRankings() , rankings);

        Assert.assertEquals(group.getTeamRanking(teamA) , 3);
        Assert.assertEquals(group.getTeamRanking(teamB) , 0);
    }




}