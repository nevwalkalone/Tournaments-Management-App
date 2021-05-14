package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    Team teamA = new Team("Celtic", new Sport("Volleyball3v3",6), AgeDivision.K12 , new Player() );
    Team teamB = new Team("Barca", new Sport("Volleyball3v3",6), AgeDivision.K12 , new Player() );
    LocalDate date;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.parse("2022-01-01");
        teamA = new Team();
        teamB = new Team();
        game = new Game("Oaka", teamA , teamB, date );

    }

    @Test
    public void notFinishedTest(){
        Assert.assertEquals(game.findWinner(),2);
    }

    @Test
    public void scoreTests(){
        game.setScoreA(5);
        game.setScoreB(2);
        game.setFinished(true);
        Assert.assertEquals(game.getScoreA(),5);
        Assert.assertEquals(game.getScoreB(),2);
        Assert.assertTrue(game.isFinished());
        Assert.assertEquals(game.findWinner(),1);
    }
    @Test
    public void basicTests(){
        Assert.assertEquals(game.getTeamA(),teamA);
        Assert.assertEquals(game.getTeamB(),teamB);
        Assert.assertEquals(game.getArena(),"Oaka");
        Assert.assertEquals(game.getDate(),date  );


    }
    @Test
    public void equalsTest() {
        LocalDate date = LocalDate.parse("2022-01-01");
        Team teamA = new Team();
        Team teamB = new Team();
        Game game = new Game( date );
        game.setTeamA(teamA);
        game.setTeamB(teamB);
        game.setArena("Oaka");
        game.setFinished(true);

        Game game2 = new Game( );
        game2.setDate(date);
        game2.setTeamA(teamA);
        game2.setTeamB(teamB);
        game2.setArena("Oaka");
        game2.setFinished(true);
        Assert.assertEquals(game,game2  );
    }

}