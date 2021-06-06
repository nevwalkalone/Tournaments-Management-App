package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RoundTest {
    Round round;
    ArrayList<LocalDate> dates ;

    @Before
    public void setUp() throws Exception {
        dates = new ArrayList<>();
        dates.add(LocalDate.parse("2021-10-10"));
        dates.add(LocalDate.parse("2021-10-11"));
        round = new Round(4,true,dates);
    }

    @Test
    public void basicTests() {
        Assert.assertEquals(round.getDates() , dates);
        Assert.assertEquals(round.getGroups().size(), 2);
        Assert.assertEquals(round.getTeamsNumber(), 4);
        Assert.assertEquals(round.getTeamsPerGroup(), 2);
        Assert.assertEquals(round.toString(), "Round{" +
                                                    "teamsNumber=" + 4 +
                                                    '}');
    }

    @Test
    public void winnersTests() {
        Credentials credentials = new Credentials("sakis7","123");
        Player player = new Player( "sakis", "rouvas" ,"Athens",  "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        ArrayList<Team> teams = new ArrayList<>();
        for (int i=0; i< 4 ; i++) {
            teams.add( new Team("Osfp"+i, new Sport("Volleyball3v3"), AgeDivision.K100 ,player,"green" )  );
        }
        round.setup(teams);
        round.getGroups().get(0).getGames().get(0).setScoreA(0);
        round.getGroups().get(0).getGames().get(0).setScoreB(1);
        round.getGroups().get(0).getGames().get(0).setFinished(true);
        round.getGroups().get(1).getGames().get(0).setScoreA(2);
        round.getGroups().get(1).getGames().get(0).setScoreB(0);
        round.getGroups().get(1).getGames().get(0).setFinished(true);

        ArrayList<Team> winners = new ArrayList<>();
        winners.add(teams.get(0));
        winners.add(teams.get(3));

        Assert.assertEquals(round.getRoundWinners(),winners);
    }

    @Test
    public void setupTests() {
        dates = new ArrayList<>();
        for (int i = 0; i <12 ; i++) {
            dates.add(LocalDate.parse("2020-01-01") );
        }

        Credentials credentials = new Credentials("sakis7","123");
        Player player = new Player( "sakis", "rouvas" ,"Athens",  "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        ArrayList<Team> teams = new ArrayList<>();
        for (int i=0; i< 8 ; i++) {
            teams.add( new Team("Osfp"+i, new Sport("Volleyball3v3"), AgeDivision.K100 ,player,"green" )  );
        }

        round = new Round(8,false,dates);
        round.setup(teams);
        Assert.assertEquals( round.getTeams(), teams);
        Assert.assertFalse( round.allGamesFinished());

    }

    @Test
    public void testEquals() {
        dates = new ArrayList<>();
        for (int i = 0; i <12 ; i++) {
            dates.add(LocalDate.parse("2020-01-01") );
        }
        Credentials credentials = new Credentials("sakis7","123");
        Player player = new Player( "sakis", "rouvas" ,"Athens",  "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        ArrayList<Team> teams = new ArrayList<>();
        for (int i=0; i< 8 ; i++) {
            teams.add( new Team("Osfp"+i, new Sport("Volleyball3v3"), AgeDivision.K100 ,player,"green" )  );
        }
        round = new Round(8,false,dates);
        round.setup(teams);

        Round round2 = new Round(8,false,dates);
        round2.setup(teams);

        Assert.assertTrue( round.equals(round2));
    }

}