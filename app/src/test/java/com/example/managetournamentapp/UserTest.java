package com.example.managetournamentapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
    Date date = new Date();
    Credentials cred = new Credentials("jeo", "4567");

    @Before
    public void setUp() throws Exception {

        User user = new User("jeo", "jiou", "697", "hh", date, cred);
    }

    @Test
    public void testgetter(){

        Assert.assertEquals(user.getPassword(),user.getLoginData().getPassword());
        Assert.assertEquals(user.getUsername(),user.getLoginData().getUsername());



    }
}