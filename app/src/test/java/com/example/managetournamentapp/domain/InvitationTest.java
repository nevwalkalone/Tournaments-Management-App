package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class InvitationTest {
    Invitation invitation;
    Player player;
    Team team;

    @Before
    public void setUp() throws Exception {
        Credentials credentials = new Credentials("sakis7","123");
        player = new Player( "sakis", "rouvas" , "69000000" , "aa@aa.aa", LocalDate.parse("2000-01-01") , credentials);
        team = new Team("Celtic", (new Sport("Basketball3v3")), AgeDivision.K15, player, "green");
        invitation = new Invitation(team);
    }

    @Test
    public void basicTests() {
        Team team2 = new Team("Celtic2", (new Sport("Basketball3v3")), AgeDivision.K15, player, "green");
        invitation = new Invitation(team);
        Assert.assertFalse(invitation.getAccepted());
        Assert.assertTrue(invitation.getPending());
        invitation.setTeam(team2);
        Assert.assertEquals(invitation.getTeam(),team2);
        Assert.assertTrue(invitation.getDate().equals(LocalDate.now()));
    }

    @Test
    public void equalTest() {
        Assert.assertEquals(invitation, new Invitation(team));
    }
}
