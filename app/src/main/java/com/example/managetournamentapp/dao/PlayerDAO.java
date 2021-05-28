package com.example.managetournamentapp.dao;


import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

public interface PlayerDAO extends UserDAO {

    void save(Player entity);

    void delete(Player entity);

    Player find(String userName);

}
