package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.ParticipationDAO;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Participation;

import java.util.ArrayList;
import java.util.List;

public class ParticipationDAOMemory implements ParticipationDAO {
    protected static ArrayList<Participation> entities = new ArrayList<>();


    @Override
    public void save(Participation entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Participation entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    @Override
    public Participation find(String teamName, String tournamentName) {
        return null;
    }

    @Override
    public ArrayList<Participation> findAll() {
        ArrayList<Participation> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }
}
