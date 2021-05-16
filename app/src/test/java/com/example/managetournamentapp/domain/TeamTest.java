package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeamTest {
    Player player,player2,player3;
    Team team;
    Credentials credentials;
    Tournament tournament;

    @Before
    public void setUp() throws Exception {
        credentials = new Credentials("sakis7","123");
        player = new Player( "sakis", "rouvas" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        player.addSportInterested(new Sport("Volleyball3v3"));
        player2 = new Player( "john", "koukos" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        player2.addSportInterested(new Sport("Volleyball3v3"));
        player3 =  new Player( "patrick", "starman" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        player3.addSportInterested(new Sport("Volleyball3v3"));
        team = new Team("Celtic", new Sport("Volleyball3v3"), AgeDivision.K100 ,player, "green" );
        tournament = new Tournament();
    }

    @Test
    public void testAddPlayers()  {
        team.addPlayer(player2);
        Assert.assertEquals(team.getCaptain(), player);
        Assert.assertEquals(team.getPlayers().size(), 2);
        Assert.assertTrue(team.getPlayers().contains(player));
        Assert.assertTrue(team.getPlayers().contains(player2));
    }

    @Test
    public void testRemovePlayers()  {
        team.addPlayer(player2);;
        team.removePlayer(player2);
        Assert.assertEquals(team.getPlayers().size(), 1);
        Assert.assertTrue(team.getPlayers().contains(player));
        Assert.assertFalse(team.getPlayers().contains(player2));
    }

    @Test
    public void testTournamentParticipations(){
        Assert.assertFalse(team.hasAnyActivePart());
        team.addPlayer(player2);
        team.addPlayer(player3);

        ArrayList<LocalDate> dates = new ArrayList<>();
        for (int i=10 ; i<25 ; i++){
            dates.add(LocalDate.parse("2021-10-"+i));
        }
        tournament = new Tournament( "nba2",dates.get(0), dates.get(dates.size()-1), "athens", new Sport("Volleyball3v3"),8,AgeDivision.K100,dates);
        Participation participation = new Participation(tournament, team);

        team.addParticipation( participation );
        Assert.assertTrue(team.getParticipations().contains(participation));
        Assert.assertTrue(team.getUndoneParticipations().contains(participation));
        team.removeParticipation( participation );
        Assert.assertFalse(team.getParticipations().contains(participation));
    }

    @Test
    public void basicTests(){
        team.setName("Barca");
        Assert.assertEquals(team.getName(), "Barca");
        team.setColors("blue");
        Assert.assertEquals(team.getColors(), "blue");
        team.addPlayer(player2);
        team.setCaptain(player2);
        Assert.assertEquals(team.getCaptain(), player2);
        Assert.assertEquals(team.getAgeDivision(), AgeDivision.K100);
        Assert.assertEquals(team.getSportType(), new Sport("Volleyball3v3"));

        Assert.assertEquals(team.toString(), "Team{" +
                                                "name='" + "Barca" + '\'' +
                                                ", sportType=" + new Sport("Volleyball3v3") +
                                                ", ageDivision=" +  AgeDivision.K100 +
                                                '}');
    }


}