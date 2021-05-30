package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

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
        for (Team t : entities){
            if ( t.getName().equals(teamName) )
                return t;
        }
        return null;
    }

    @Override
    public ArrayList<Team> findByTournament(Tournament tournament) {
        ArrayList<Team> results = new ArrayList<>();
        for (Team t : entities){
            for (Participation p : t.getParticipations()){
                if (p.getTournament().getTitle().equals(tournament))
                    results.add(t);
            }
        }
        return results;
    }

}