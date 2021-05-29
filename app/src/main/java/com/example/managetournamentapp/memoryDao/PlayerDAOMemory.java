package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;

public class PlayerDAOMemory implements PlayerDAO {
    protected static ArrayList<Player> entities = new ArrayList<>();


    @Override
    public Player verify(Credentials credentials) {
        return null;
    }

    @Override
    public void save(Player entity) {
        entities.add(entity);
    }

    @Override
    public void delete(Player entity) {
        entities.remove(entity);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Player find(String userName) {
        return null;
    }
}
