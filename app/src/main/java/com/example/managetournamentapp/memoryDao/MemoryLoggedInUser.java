package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.User;

public class MemoryLoggedInUser implements LoggedInUser {
//    private static User user = null;

    //random player
    private static User user =(new PlayerDAOMemory()).find("tom");

    //random organizer
//    private static User user = (new OrganizerDAOMemory().findByTitle("ESKA"));

    public MemoryLoggedInUser() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void clear() {
        user = null;
    }

}