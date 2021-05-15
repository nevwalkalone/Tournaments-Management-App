package com.example.managetournamentapp.domain;

public class Credentials {

    private String username, password;

    // Default Constructor
    public Credentials() {
        this.username = "";
        this.password = "";

    }

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;

        boolean equal = false;
        if (other instanceof Credentials) {
            Credentials otherCred = (Credentials) other;
            if ((username.equals(otherCred.username) && otherCred.username != null)
                    && (password.equals(otherCred.password) && otherCred.password != null))
                equal = true;
        }
        return equal;
    }
}
