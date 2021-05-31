package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.LoggedInUserDAO;
import com.example.managetournamentapp.domain.User;

public class MemoryLoggedInUser implements LoggedInUserDAO
{
    private static User user = (new PlayerDAOMemory()).find("tom");

    public MemoryLoggedInUser(){}

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

}