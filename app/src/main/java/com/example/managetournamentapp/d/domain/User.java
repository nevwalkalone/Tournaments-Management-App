package com.example.managetournamentapp.d.domain;

import com.example.managetournamentapp.d.domain.Credentials;
import com.example.managetournamentapp.d.domain.Tournament;

import java.util.*;

public class User {

    private String name, surname, phoneNumber, email;
    private Date birthDate;
    private Credentials credentials;

    public User(String name, String surname, String phoneNumber, String email, Date birthDate, Credentials credentials) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void signUp() {

    }

    public void login() {

    }

    public void logout() {

    }

    public void deleteAccount() {

    }

    public void editAccount() {

    }

    public ArrayList<Tournament> searchTournament() {
        ArrayList<Tournament> tournaments = new ArrayList<>();
        return tournaments;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", credentials=" + credentials +
                '}';
    }


}
