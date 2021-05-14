package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.Date;

public class User {

    private String name, surname, phoneNumber, email;
    private LocalDate birthDate;
    private Credentials credentials;

    public User() {
        this.name = "";
        this.surname = "";
        this.phoneNumber = "";
        this.email = "";
        this.birthDate = null;
        this.credentials = null;

    }

    public User(String name, String surname, String phoneNumber, String email, LocalDate birthDate, Credentials credentials) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
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

    public boolean equals(Object other) {
        boolean equal = false;
        if (other instanceof User) {
            User otherUser = (User) other;
            if (name.equals(otherUser.name) && surname.equals(otherUser.surname) && phoneNumber.equals(otherUser.phoneNumber)
                    && birthDate.equals(otherUser.birthDate) && credentials.equals(otherUser.credentials))
                equal = true;
        }
        return equal;
    }


}
