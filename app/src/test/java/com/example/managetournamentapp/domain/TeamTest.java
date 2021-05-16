package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeamTest {
    private Player player,player2,player3;
    private Team team,team2,team3;
    private Credentials credentials;
    private Tournament tournament,tournament2,tournament3;

    private ArrayList<LocalDate> dates = new ArrayList<>();
    private Participation participationTemp,participationTemp2;

    @Before
    public void setUp() throws Exception {
        for (int i = 1; i < 64; i++) {
            dates.add(LocalDate.now());
        }

        credentials = new Credentials("sakis7","123");
        player = new Player( "sakis", "rouvas" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        player.addSportInterested(new Sport("Volleyball3v3"));
        player2 = new Player( "john", "koukos" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        player2.addSportInterested(new Sport("Volleyball3v3"));
        player3 =  new Player( "patrick", "starman" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        player3.addSportInterested(new Sport("Volleyball3v3"));
        team = new Team("Celtic", new Sport("Volleyball3v3"), AgeDivision.K100 ,player, "green" );

        tournament = new Tournament();
        tournament2 = new Tournament("TOURNOUA1", LocalDate.parse("2021-05-10"), LocalDate.parse("2021-05-29"), "ATHENS", (new Sport("Volleyball3v3")),
                32, AgeDivision.K100, dates);
        participationTemp = new Participation(tournament2,team);

        tournament3 = new Tournament("TOURNOUA2", LocalDate.parse("2021-05-28"), LocalDate.parse("2021-05-30"), "ATHENS", (new Sport("Volleyball3v3")),
                32, AgeDivision.K100, dates);

        participationTemp2 = new Participation(tournament3, team);

        team2 = new Team();
        team3= new Team("Boston", new Sport("Volleyball3v3"), AgeDivision.K100 ,player, "white" );


    }

    @Test
    public void testAddPlayers()  {
        team.addPlayer(null);
        //only the captain
        Assert.assertEquals(1,team.getPlayers().size());
        team.addPlayer(player2);
        team.invitePlayer(player3);
        player3.replyToInvitation(player3.getInvitesReceived().get(0),true);
        Assert.assertEquals(team.getCaptain(), player);
        Assert.assertEquals(team.getPlayers().size(), 3);
        Assert.assertTrue(team.getPlayers().contains(player));
        Assert.assertTrue(team.getPlayers().contains(player2));
        Assert.assertTrue(team.getPlayers().contains(player3));
    }

    @Test
    public void testRemovePlayers()  {
        team.removePlayer(null);
        Assert.assertEquals(1,team.getPlayers().size());
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
        team.addParticipation(participationTemp);
        Assert.assertTrue(team.hasAnyActivePart());
        team.addParticipation(participationTemp);

        //already contains the participation, can't be added for the 2nd time
        Assert.assertEquals(1,team.getParticipations().size());
        team.removeParticipation(participationTemp);
        participationTemp = null;
        team.removeParticipation(participationTemp);
        Assert.assertEquals(0,team.getParticipations().size());
        team.addParticipation(participationTemp);
        Assert.assertEquals(0,team.getParticipations().size());
    }

    @Test
    public void basicTests(){
        //default constructor, so team name is null
        Assert.assertNull(team2.getName());

        team.setName("Barca");
        Assert.assertEquals(team.getName(), "Barca");
        team.setColors(null);
        Assert.assertEquals("green",team.getColors());
        team.setName(null);
        team.setCaptain(null);
        //No changes because of null values
        Assert.assertEquals("sakis",team.getCaptain().getName());
        Assert.assertEquals("Barca",team.getName());
        team.setColors("blue");
        Assert.assertEquals(team.getColors(), "blue");
        team.addPlayer(player2);
        team.setCaptain(player2);
        Assert.assertEquals(team.getCaptain(), player2);
        Assert.assertEquals(team.getAgeDivision(), AgeDivision.K100);
        Assert.assertEquals(team.getSportType(), new Sport("Volleyball3v3"));
        Assert.assertFalse(team.hasAnyActivePart());

        Assert.assertEquals(team.toString(), "Team{" +
                                                "name='" + "Barca" + '\'' +
                                                ", sportType=" + new Sport("Volleyball3v3") +
                                                ", ageDivision=" +  AgeDivision.K100 +
                                                '}');
    }

    @Test
    public void canParticipateTest(){
       //not enough players
        Assert.assertFalse(team.canParticipate(participationTemp));
        team.addPlayer(player2);
        team.addPlayer(player3);

        //if a player has joined the same tournament with another team
        //team can't participate
        participationTemp2 = new Participation(tournament2,team3);
        player.getTeamsJoined().add(team3);
        team3.getParticipations().add(participationTemp2);
        Assert.assertFalse(team.canParticipate(participationTemp2));

        participationTemp.setTournament(tournament);
        team.addParticipation(participationTemp);
        tournament.setAgeDivision(AgeDivision.valueOf("K12"));
        Assert.assertFalse(team.canParticipate(participationTemp));
        tournament.setAgeDivision(AgeDivision.valueOf("K100"));
        tournament.setSportType(new Sport("Volleyball6v6"));
        Assert.assertFalse(team.canParticipate(participationTemp));

        participationTemp.setTournament(tournament2);
        team.getParticipations().add(participationTemp);

        //can't participate in other participation, because
        //there is one already running
        Assert.assertFalse(team.canParticipate(participationTemp2));


        participationTemp2 = new Participation(tournament3,team);

        participationTemp.setStartDate(LocalDate.parse("2021-05-18"));

        //can't participate because there is already 1 participation
        //at the same dates
        Assert.assertFalse(team.canParticipate(participationTemp2));
    }

}