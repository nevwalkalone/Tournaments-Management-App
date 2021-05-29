package com.example.managetournamentapp.dao;


import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.User;

public interface PlayerDAO {

    Player verify(Credentials credentials);

    void save(Player entity);

    void delete(Player entity);

    void deleteAll();

    Player find(String userName);

}
