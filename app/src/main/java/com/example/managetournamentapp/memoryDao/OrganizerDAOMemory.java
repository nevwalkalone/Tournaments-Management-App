package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;

public class OrganizerDAOMemory implements OrganizerDAO {
    protected static ArrayList<Organizer> entities = new ArrayList<>();

    @Override
    public Player verify(Credentials credentials) {
        return null;
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

    }

    @Override
    public Organizer find(String title) {
        for (Organizer o : entities){
            if (o.getTitle().equals(title))
                return o;
        }
        return null;
    }
}
