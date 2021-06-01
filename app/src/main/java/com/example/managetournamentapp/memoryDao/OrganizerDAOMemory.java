package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class OrganizerDAOMemory implements OrganizerDAO {
    protected static ArrayList<Organizer> entities = new ArrayList<>();

    @Override
    public boolean verify(Credentials credentials) {
        boolean valid = false;
        if(exist(credentials))
            valid = true;
        return valid;
    }

    @Override
    public void save(Organizer entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Organizer entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    @Override
    public Organizer findByTitle(String title) {
        for (Organizer o : entities) {
            if (o.getTitle().equals(title))
                return o;
        }
        return null;
    }

    @Override
    public Organizer findByCredentials(Credentials credentials) {
        for (Organizer o : entities) {
            if (o.getCredentials().equals(credentials))
                return o;
        }
        return null;
    }

    @Override
    public boolean exist(Credentials credentials) {
        for (Organizer o : entities) {
            if (o.getCredentials().equals(credentials))
                return true;
        }
        return false;
    }

    @Override
    public ArrayList<Organizer> findAll() {
        ArrayList<Organizer> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }
}
