package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.User;

public interface LoggedInUserDAO {

    void setUser(User user);

    User getUser();
}
