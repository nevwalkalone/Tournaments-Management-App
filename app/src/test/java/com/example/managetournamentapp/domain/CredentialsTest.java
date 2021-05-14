package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CredentialsTest {
    private Credentials credentials;
    private Credentials credentials2 = new Credentials("Giannis", "123456");
    private Credentials credentials3 = new Credentials("Giannis", "GioGio");
    private Credentials credentials4 = new Credentials("Nondas", "123456");
    private Credentials credentials5 = new Credentials();

    @Before
    public void setUp() throws Exception {
        credentials = new Credentials("Nondas", "123456");
        credentials2 = new Credentials("Giannis", "123456");
        credentials3 = new Credentials("Giannis", "GioGio");
        credentials4 = new Credentials("Nondas", "123456");
        credentials5 = new Credentials();
    }

    @Test
    public void testEquals() {

        Credentials credentials4 = new Credentials("Nondas", "123456");
        Assert.assertEquals(credentials4, credentials);

    }

    @Test
    public void testNotEquals() {

        Assert.assertNotEquals(credentials2, credentials);
        Assert.assertNotEquals(credentials3, credentials);
        Assert.assertNotEquals(credentials5, credentials);

    }

    // Tester for toString()
    @Test
    public void testPrinting() {


        Assert.assertEquals(credentials4.toString(), credentials.toString());

    }

    // testers for Getters and Setter

    @Test
    public void getUsernameTest() {
        Assert.assertEquals("Nondas", credentials.getUsername());
    }

    @Test
    public void getPasswordTest() {
        Assert.assertEquals("123456", credentials.getPassword());
    }

    @Test
    public void testSetterGetterUsername() {

        String newName = "Giorgos";
        credentials.setUsername(newName);
        Assert.assertEquals(newName, credentials.getUsername());

    }

    @Test
    public void testSetterGetterPassword() {

        String newPassword = "456789";
        credentials.setPassword(newPassword);
        Assert.assertEquals(newPassword, credentials.getPassword());

    }
}