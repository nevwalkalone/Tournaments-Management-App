package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.InvitationDAO;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Invitation;

import java.time.LocalDate;
import java.util.ArrayList;

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

    }

    @Override
    public void find(String teamName, LocalDate dateSent) {

    }
}
