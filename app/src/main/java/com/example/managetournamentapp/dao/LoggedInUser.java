package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.User;

public interface LoggedInUser {

    void setUser(User user);

    User getUser();

    void clear();

}
