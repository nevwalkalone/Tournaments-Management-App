package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CredentialsTest {
    private Credentials credentials;
    @Before
    public void setUp() throws Exception {
        credentials = new Credentials("Nondas","123456");
    }

    @Test
    public void getUsernameTest(){
        Assert.assertEquals("Nondas",credentials.getUsername());
    }

    @Test
    public void getPasswordTest(){
        Assert.assertEquals("123456",credentials.getPassword());
    }

    @Test
    public void checkPrinting(){
        credentials.setUsername("Giorgos");
        credentials.setPassword("54321");
        String print_check = credentials.toString();
        Assert.assertEquals("Credentials{" +
                "username='" + "Giorgos"+ '\'' +
                ", password='" + "54321" + '\'' +
                '}',print_check);
    }
}