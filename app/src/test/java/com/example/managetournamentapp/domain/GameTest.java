package com.example.managetournamentapp.domain;

import android.media.AudioTrack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class GameTest {
    Credentials credentials = new Credentials("sakis7","123");
    Player player;
    Game game;
    Team teamA ;
    Team teamB ;
    LocalDate date;

    @Before
    public void setUp() throws Exception {
        player = new Player( "sakis", "rouvas" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        date = LocalDate.parse("2022-01-01");
        teamA = new Team("Celtic", new Sport("Volleyball3v3",6), AgeDivision.K12 ,player );
        teamB = new Team("Barca", new Sport("Volleyball3v3",6), AgeDivision.K12 ,player );
        game = new Game("Oaka", teamA , teamB, date );
        System.out.println(game);

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
        Assert.assertEquals(game.toString(), "Game{" +
                                            "arena='" + "Oaka" + '\'' +
                                            ", scoreA=" + 0 +
                                            ", scoreB=" + 0 +
//                                            ", teamA=" + teamA +
//                                            ", teamB=" + teamB +
                                            ", date=" + date +
                                            ", isFinished=" + false +
                                            '}' );
    }

    @Test
    public void equalsTest() {
        LocalDate date = LocalDate.parse("2022-01-01");
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