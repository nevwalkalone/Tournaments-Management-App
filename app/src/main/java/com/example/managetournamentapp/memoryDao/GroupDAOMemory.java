package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.GroupDAO;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupDAOMemory implements GroupDAO {
    protected static ArrayList<Group> entities = new ArrayList<>();


    @Override
    public void save(Group entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Group entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    @Override
    public Group find() {
        return null;
    }

    @Override
    public ArrayList<Group> findAll() {
        ArrayList<Group> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }
}
