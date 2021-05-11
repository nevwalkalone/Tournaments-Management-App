package com.example.managetournamentapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
    Date date = new Date();
    Credentials cred = new Credentials("jeo", "4567");
    private User user;
    @Before
    public void setUp() throws Exception {

         user = new User("jeo", "jiou", "697", "hh", date, cred);
    }

    @Test
    public void testgetter(){

        User user2 = new User("jeo", "jiou", "697", "hh", date, cred);

        Assert.assertEquals(user.getSurname(), user2.getSurname());




    }
}