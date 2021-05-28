package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Group;

public interface GroupDAO {

    void save(Group entity);

    void delete(Group entity);

    // todo
    Group find();

}
