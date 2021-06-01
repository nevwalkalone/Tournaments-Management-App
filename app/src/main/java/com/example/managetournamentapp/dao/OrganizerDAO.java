package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;

public interface OrganizerDAO {

    boolean verify(Credentials credentials);

    /**
     * Saves a specific organizer.
     *
     * @param entity Organizer to be saved.
     */
    void save(Organizer entity);

    /**
     * Finds a specific organizer.
     *
     * @param title Title of the organizer.
     * @return Organizer with the name specified.
     */
    Organizer findByTitle(String title);

    /**
     * Finds a specific organizer.
     *
     * @param credentials credentials of the organizer.
     * @return Organizer with the name specified.
     */
    Organizer findByCredentials(Credentials credentials);

    /**
     * Finds all organizers.
     *
     * @return All organizers.
     */
    ArrayList<Organizer> findAll();

    /**
     * Deletes a specific organizer.
     *
     * @param entity Organizer to be deleted.
     */
    void delete(Organizer entity);

    /**
     * Deletes all organizers.
     */
    void deleteAll();


    /**
     * Check if user who tries login exist in DAO.
     *
     * @param credentials User input credentials
     * @return true if User exists in DAO
     */
    boolean exist(Credentials credentials);


}
