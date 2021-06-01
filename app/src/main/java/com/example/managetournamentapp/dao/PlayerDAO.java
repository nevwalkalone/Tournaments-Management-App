package com.example.managetournamentapp.dao;


import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;

public interface PlayerDAO {

    boolean verify(Credentials credentials);

    /**
     * Saves a specific player.
     * @param entity Player to be saved.
     */
    void save(Player entity);

    /**
     * Finds a specific player.
     * @param userName Player username.
     * @return Player with the specific username.
     */
    Player find(String userName);

    /**
     * Finds all players.
     * @return All players.
     */
    ArrayList<Player> findAll();

    /**
     * Deletes a specific player.
     * @param entity Player to be deleted.
     */
    void delete(Player entity);

    /**
     * Deletes all players.
     */
    void deleteAll();

    /**
     *  Check if user who tries login exist in DAO.
     * @param credentials User input credentials
     * @return true if User exists in DAO
     */
    boolean exist(Credentials credentials);




}
