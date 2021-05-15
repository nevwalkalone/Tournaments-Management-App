package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TournamentTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testParticipations(){


        ArrayList<LocalDate> dates = new ArrayList<>();
        for (int i=10 ; i<25 ; i++){
            dates.add(LocalDate.parse("2021-10-"+i));
        }

    }


}