package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Round;

public interface RoundDAO {

    void save(Round entity);

    void delete(Round entity);

    void deleteAll();
}
