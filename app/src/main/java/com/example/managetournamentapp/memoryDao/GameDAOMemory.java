package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.GameDAO;
import com.example.managetournamentapp.domain.Game;

import java.time.LocalDate;
import java.util.ArrayList;

public class GameDAOMemory implements GameDAO {
    protected static ArrayList<Game> entities = new ArrayList<>();

    @Override
    public void save(Game entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Game entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Game find(String nameTeamA, String nameTeamB, LocalDate matchDate) {
        return null;
    }
}
