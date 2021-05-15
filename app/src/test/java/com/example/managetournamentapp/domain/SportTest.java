package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Test;


public class SportTest {

  //  @Before
    public void setUp() throws Exception {
    }

    @Test
    public void wrongSportSettingsTest(){
        //wrong name
        Sport sport = new Sport("Basketball5v5fff");
        Assert.assertEquals(null,sport.getName());

        //wrong number of players
        sport.changeSetup("Volleyball6v6");
        Assert.assertEquals(0,sport.getMinimumPlayers());

        //wrong game duration
        sport.changeSetup("Basketball2v2");


        //testing football 7v7 and volleyball 6v6
        sport.changeSetup("Football7v7");
        Assert.assertEquals("Football7v7",sport.getName());
        Assert.assertEquals(14,sport.getMinimumPlayers());


        sport.changeSetup("Volleyball6v6");
        Assert.assertEquals("Volleyball6v6",sport.getName());
        Assert.assertEquals(12,sport.getMinimumPlayers());

    }

    @Test
    public void printTest(){
        Sport sport1 = new Sport("Basketball2v2");
        String string = sport1.toString();
        Assert.assertEquals("Sport{" +
                "name='" + sport1.getName()+ '\'' +
                ", minimumPlayers=" + sport1.getMinimumPlayers() +
                '}',string);
    }

    /**
     * This method checks the equals method.
     */
    @Test
    public void testEqualsObject(){
        Sport sport1 = new Sport("Basketball3v3");
        Assert.assertEquals(sport1,sport1);
        Sport sport2 = new Sport("Basketball3v3");
        Assert.assertEquals(sport1,sport2);
        sport2.changeSetup("Basketball5v5");
        Assert.assertFalse(sport1.equals(sport2));
        sport2 = null;
        Assert.assertFalse(sport1.equals(sport2));

        Game temp = new Game();
        Assert.assertFalse(sport1.equals(temp));

        Sport sport3 = new Sport("Basketball3v3");

        Assert.assertFalse(sport1.equals(sport3));

        Sport sport4 = new Sport("Basketball3v3");

        Assert.assertFalse(sport1.equals(sport4));

    }
}