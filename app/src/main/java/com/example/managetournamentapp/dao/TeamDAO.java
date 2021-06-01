package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public interface TeamDAO {

    /**
     * Saves a specific team.
     * @param entity Team to be saved.
     */
    void save(Team entity);

    /**
     * Finds a specific team
     * @param teamName Team name.
     * @return Team with the specific name.
     */
    Team find(String teamName);

    /**
     * Finds all teams.
     * @return All teams.
     */
    ArrayList<Team> findAll();

    /**
     * Deletes a specific team.
     * @param entity Team to be deleted.
     */
    void delete(Team entity);

    /**
     * Deletes all teams
     */
    void deleteAll();



    public ArrayList<Team> findByTournament(Tournament tournament);

}
