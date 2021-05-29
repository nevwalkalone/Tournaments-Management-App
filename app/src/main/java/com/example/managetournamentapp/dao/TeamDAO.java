package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Team;

public interface TeamDAO {

    void save(Team entity);

    void delete(Team entity);

    void deleteAll();

    Team find(String teamName);

}
