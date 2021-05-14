package com.example.managetournamentapp.domain;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class UserTest {
    private User user;
    private User user2;
    private User user3;
    private LocalDate date;
    private LocalDate date2;
    private Credentials credentials;
    private Credentials credentials2;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.parse("1994-05-03");
        date2 = LocalDate.parse("2000-01-04");
        credentials = new Credentials("Nondic", "123456");
        credentials2 = new Credentials("zaaachos", "123456");
        user = new User("Nondas", "Ioannou", "69xxxxxxx", "nondas@gmail.com", date, credentials);
        user2 = new User("Giorgos", "Zachariadis", "69xxxxxxx", "zacchos@gmail.com", date2, credentials2);
        user3 = new User();
    }

    @Test
    public void testEquals() {

        User userTest = new User("Nondas", "Ioannou", "69xxxxxxx", "nondas@gmail.com", date, credentials);
        Assert.assertEquals(userTest, user);

    }

    @Test
    public void testNotEquals() {

        Assert.assertNotEquals(user2, user);
        Assert.assertNotEquals(user3, user);
        Assert.assertNotEquals(user2, user3);

    }

    // Tester for toString()
    @Test
    public void testPrinting() {

        User userTest = new User("Nondas", "Ioannou", "69xxxxxxx", "nondas@gmail.com", date, credentials);
        Assert.assertEquals(userTest.toString(), user.toString());

    }

    // testers for Getters and Setter

    @Test
    public void getNameTest() {
        Assert.assertEquals("Nondas", user.getName());
    }

    @Test
    public void getSurnameTest() {
        Assert.assertEquals("Zachariadis", user2.getSurname());
    }

    @Test
    public void getPhoneNumber() {
        String phone = "69xxxxxxx";
        Assert.assertEquals(phone, user.getPhoneNumber());
    }

    @Test
    public void getBirthdayTest() {
        LocalDate dateTest = LocalDate.parse("2000-01-04");
        Assert.assertEquals(dateTest, user2.getBirthDate());
    }

    @Test
    public void getEmailTest() {
        String emailTest = "nondas@gmail.com";
        Assert.assertEquals(emailTest, user.getEmail());
    }

    @Test
    public void getCredentialsTest() {
        Credentials credentialsTest = new Credentials("zaaachos", "123456");
        Assert.assertEquals(credentialsTest, user2.getCredentials());
    }


    @Test
    public void testSetterGetterName() {

        String newName = "Christophoros";
        user.setName(newName);
        Assert.assertEquals(newName, user.getName());

    }

    @Test
    public void testSetterGetterSurname() {

        String newSurname = "Trakas";
        user2.setSurname(newSurname);
        Assert.assertEquals(newSurname, user2.getSurname());

    }

    @Test
    public void testSetterGetterPhoneNumber() {

        String phoneNumber = "697xxxxxxx";
        user2.setPhoneNumber(phoneNumber);
        Assert.assertEquals(phoneNumber, user2.getPhoneNumber());

    }

    @Test
    public void testSetterGetterEmail() {

        String email = "christo@yahoo.gr";
        user3.setEmail(email);
        Assert.assertEquals(email, user3.getEmail());

    }

    @Test
    public void testSetterGetterBirthdate() {

        LocalDate birthDate = LocalDate.parse("1999-03-04");
        user.setBirthDate(birthDate);
        Assert.assertEquals(birthDate, user.getBirthDate());

    }

    @Test
    public void testSetterGetterCredentials() {

        Credentials cred = new Credentials("nikos!", "123789");
        user2.setCredentials(cred);
        Assert.assertEquals(cred, user2.getCredentials());

    }
}