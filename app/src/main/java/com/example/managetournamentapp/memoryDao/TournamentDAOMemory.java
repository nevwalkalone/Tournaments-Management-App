package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
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
        entities = new ArrayList<>();

    }

    @Override
    public Tournament find(String tournamentTitle) {
        for (Tournament t : entities) {
            if (t.getTitle().equals(tournamentTitle))
                return t;
        }
        return null;
    }

    @Override
    public ArrayList<Tournament> findAll() {
        ArrayList<Tournament> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    public ArrayList<Tournament> findByOrganizer(Organizer organizer) {
        if (organizer == null)
            return new ArrayList<Tournament>();

        return organizer.getTournaments();
    }

}
