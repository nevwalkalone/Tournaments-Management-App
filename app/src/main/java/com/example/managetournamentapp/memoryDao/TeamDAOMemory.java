package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Team;

import java.util.ArrayList;

public class TeamDAOMemory implements TeamDAO {
    protected static ArrayList<Team> entities = new ArrayList<>();

    @Override
    public void save(Team entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Team entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Team find(String teamName) {
        return null;
    }
}
