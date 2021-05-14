package com.example.managetournamentapp.domain;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class UserTest {
    LocalDate tempDate = LocalDate.now();
    Credentials cred = new Credentials("jeo", "4567");
    private User user;
    @Before
    public void setUp() throws Exception {

         user = new User("jeo", "jiou", "697", "hh", tempDate, cred);
    }

    @Test
    public void testgetter(){

        User user2 = new User("jeo", "jiou", "697", "hh", tempDate, cred);

        Assert.assertEquals(user.getSurname(), user2.getSurname());




    }
}