package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.User;

public interface LoggedInUser {

    void setUser(User user);

    static User getUser() {
        return null;
    }

    void clear();

}
