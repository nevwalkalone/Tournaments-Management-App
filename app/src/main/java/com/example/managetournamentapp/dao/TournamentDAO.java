package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Tournament;

public interface TournamentDAO {

    void save(Tournament entity);

    void delete(Tournament entity);

    void deleteAll();

    Tournament find(String tournamentName);

}
