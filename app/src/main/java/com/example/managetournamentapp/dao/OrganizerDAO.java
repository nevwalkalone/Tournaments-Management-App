package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;

public interface OrganizerDAO {

    Player verify(Credentials credentials);

    /**
     * Saves a specific organizer.
     * @param entity Organizer to be saved.
     */
    void save(Organizer entity);

    /**
     * Finds a specific organizer.
     * @param name Name of the organizer.
     * @return Organizer with the name specified.
     */
    Organizer find(String name);

    /**
     * Finds all organizers.
     * @return All organizers.
     */
    ArrayList<Organizer> findAll();

    /**
     * Deletes a specific organizer.
     * @param entity Organizer to be deleted.
     */
    void delete(Organizer entity);

    /**
     * Deletes all organizers.
     */
    void deleteAll();


}
