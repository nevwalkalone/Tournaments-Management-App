package com.example.managetournamentapp.domain;

public class Credentials {

    private String username, password;

    public Credentials(){

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


    public boolean equals(Object other){
        boolean equal = false;
        if ( other instanceof Credentials ){
            Credentials otherCred = (Credentials) other;
            if ( username.equals(otherCred.username) && password.equals(otherCred.password) )
                equal = true;
        }
        return equal;
    }
}
