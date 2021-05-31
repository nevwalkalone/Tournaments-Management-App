package com.example.managetournamentapp.dao;


import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.User;

import java.util.ArrayList;

public interface PlayerDAO {

    Player verify(Credentials credentials);

    void save(Player entity);

    void delete(Player entity);

    void deleteAll();

    ArrayList<Player> findAll();

    Player find(String userName);

}
