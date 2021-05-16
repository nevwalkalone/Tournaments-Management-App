package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TournamentTest {

    private Tournament tournament;
    private Tournament tournament2;
    private Tournament tournament3;
    private Tournament tournament4;
    private Team team;
    private  Player player;
    ArrayList<LocalDate> dates;
    ArrayList<LocalDate> dates2;

    @Before
    public void setUp() throws Exception {
        dates = new ArrayList<>();
        dates2 = new ArrayList<>();
        for (int i = 1; i < 64; i++) {
            dates.add(LocalDate.now());
        }
        for (int i = 1; i < 64; i++) {
            dates2.add(LocalDate.now());
        }
        Credentials credentials = new Credentials("sakis7","123");
        player = new Player( "sakis", "rouvas" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        team = new Team("Celtic", new Sport("Volleyball3v3"), AgeDivision.K100 ,player, "green" );
        tournament = new Tournament("TOURNOUA1", LocalDate.parse("2021-08-01"), LocalDate.parse("2021-08-31"), "ATHENS", (new Sport("Basketball3v3")),
                32, AgeDivision.K15, dates);
        tournament2 = new Tournament("TOURNOUA1", LocalDate.parse("2021-08-01"), LocalDate.parse("2021-08-31"), "ATHENS", (new Sport("Basketball3v3")),
                32, AgeDivision.K15, dates);
        tournament3 = new Tournament("TOURNOUA2", LocalDate.parse("2021-07-01"), LocalDate.parse("2021-07-31"), "NAUPLIO", (new Sport("Basketball3v3")),
                32, AgeDivision.K18, dates2);
        tournament4 = new Tournament();


    }


    @Test
    public void testPrint() {

        Assert.assertEquals(tournament2.toString(), tournament.toString());

    }

    @Test
    public void testEquals() {


        tournament.setDescription("TOURNOUA1111");
        tournament2.setDescription("TOURNOUA1111");
        Assert.assertEquals(tournament2, tournament);

    }

    @Test
    public void testNotEquals() {

        Assert.assertNotEquals(tournament2, tournament3);
        Assert.assertNotEquals(tournament3, tournament);
        Assert.assertNotEquals(tournament4, tournament);

    }

    // Tester Getters and Setters
    @Test
    public void testGetMAX_TEAMS_NUMBER() {

        Assert.assertEquals(tournament2.getMAX_TEAMS_NUMBER(), tournament.getMAX_TEAMS_NUMBER());

    }

    @Test
    public void testInitRounds() {

        Assert.assertEquals(tournament2.getRounds(), tournament.getRounds());

    }

    @Test
    public void testIsRunning() {

        //TODO IF TODAY DOES NOT RUN
//        Assert.assertTrue(tournament.isRunning());

        tournament.setStartDate(LocalDate.parse("2030-06-02"));
        tournament.setFinishDate(LocalDate.parse("2030-06-30"));
        Assert.assertFalse(tournament.isRunning());


    }

    @Test
    public void testIsFull() {

        Assert.assertFalse(tournament4.isFull());

        for (int i = 0; i < 32; i++) {
            tournament4.addParticipation(new Participation(tournament4, team));
        }
        Assert.assertTrue(tournament4.isFull());


    }


}