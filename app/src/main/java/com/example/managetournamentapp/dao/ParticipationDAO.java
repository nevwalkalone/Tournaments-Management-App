package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Participation;

public interface ParticipationDAO {

    void save(Participation entity);

    void delete(Participation entity);

    void deleteAll();

    Participation find(String teamName, String tournamentName);

}
