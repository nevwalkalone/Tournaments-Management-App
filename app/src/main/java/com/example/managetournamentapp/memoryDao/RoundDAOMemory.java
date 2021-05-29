package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.RoundDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Round;

import java.util.ArrayList;

public class RoundDAOMemory implements RoundDAO {
    protected static ArrayList<Round> entities = new ArrayList<>();

    @Override
    public void save(Round entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Round entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {

    }
}
