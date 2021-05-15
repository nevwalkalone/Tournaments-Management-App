package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoundTest {
    Round round;
    List<LocalDate> dates ;

    @Before
    public void setUp() throws Exception {
        dates = new ArrayList<>();
        dates.add(LocalDate.parse("2021-10-10"));
        dates.add(LocalDate.parse("2021-10-11"));
        round = new Round(4,true,dates);
    }

    @Test
    public void basicTests() {
        Assert.assertEquals(round.getGroups().size(), 2);
        Assert.assertEquals(round.getTeamsNumber(), 4);
        Assert.assertEquals(round.toString(), "Round{" +
                                                    "teamsNumber=" + 4 +
                                                    '}');
    }

}