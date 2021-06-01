package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;
import java.util.ArrayList;

public interface TournamentDAO {

    /**
     * Saves a specific tournament.
     * @param entity Tournament to be saved.
     */
    void save(Tournament entity);

    /**
     * Finds a specific tournament.
     * @param tournamentName Tournament name.
     * @return Tournament with the specific name.
     */
    Tournament find(String tournamentName);

    /**
     * Finds all tournaments.
     * @return All tournaments.
     */
    ArrayList<Tournament> findAll();

    //TODO
    ArrayList<Tournament> findByOrganizer(Organizer organizer);

    /**
     * Deletes a specific tournament.
     * @param entity
     */
    void delete(Tournament entity);

    /**
     * Deletes all tournaments.
     */
    void deleteAll();



}
