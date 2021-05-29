package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Group;

import java.time.LocalDate;

public interface GameDAO {

    void save(Game entity);

    void delete(Game entity);

    void deleteAll();

    Game find(String nameTeamA, String nameTeamB, LocalDate matchDate);
}
