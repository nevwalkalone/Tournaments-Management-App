package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public interface TeamDAO {

    void save(Team entity);

    void delete(Team entity);

    void deleteAll();

    Team find(String teamName);

    public ArrayList<Team> findByTournament(Tournament tournament);

}
