package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface TournamentDAO {

    void save(Tournament entity);

    void delete(Tournament entity);

    void deleteAll();

    Tournament find(String tournamentName);

    ArrayList<Tournament> findByOrganizer(Organizer organizer);

}
