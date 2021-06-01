package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Group;

import java.util.ArrayList;

public interface GroupDAO {

    /**
     * Saves a specific group.
     * @param entity
     */
    void save(Group entity);

    //TODO
    Group find();

    /**
     * Finds all groups.
     * @return All groups.
     */
    ArrayList<Group> findAll();

    /**
     * Deletes a specific group.
     * @param entity
     */
    void delete(Group entity);

    /**
     * Deletes all groups.
     */
    void deleteAll();

}
