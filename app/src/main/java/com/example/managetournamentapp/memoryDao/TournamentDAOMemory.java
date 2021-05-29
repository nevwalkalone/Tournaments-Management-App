package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class TournamentDAOMemory implements TournamentDAO {
    protected static ArrayList<Tournament> entities = new ArrayList<>();

    @Override
    public void save(Tournament entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Tournament entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Tournament find(String tournamentName) {
        return null;
    }
}
