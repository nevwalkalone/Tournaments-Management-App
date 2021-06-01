package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.InvitationDAO;
import com.example.managetournamentapp.domain.Invitation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvitationDAOMemory implements InvitationDAO {
    protected static ArrayList<Invitation> entities = new ArrayList<>();


    @Override
    public void save(Invitation entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Invitation entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    @Override
    //TODO
    public void find(String teamName, LocalDate dateSent) {

    }

    @Override
    public ArrayList<Invitation> findAll() {
        ArrayList<Invitation> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }
}
