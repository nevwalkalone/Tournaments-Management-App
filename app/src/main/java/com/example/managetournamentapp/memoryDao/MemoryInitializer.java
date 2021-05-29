package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.GameDAO;
import com.example.managetournamentapp.dao.GroupDAO;
import com.example.managetournamentapp.dao.Initializer;
import com.example.managetournamentapp.dao.InvitationDAO;
import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.dao.ParticipationDAO;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.RoundDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.dao.TournamentDAO;

public class MemoryInitializer extends Initializer {


    @Override
    protected void eraseData() {
        getGroupDAO().deleteAll();
        getGameDAO().deleteAll();
        getInvitationDAO().deleteAll();
        getOrganizerDAO().deleteAll();
        getParticipationDAO().deleteAll();
        getPlayerDAO().deleteAll();
        getRoundDAO().deleteAll();
        getTeamDAO().deleteAll();
        getTournamentDAO().deleteAll();

    }

    @Override
    public GameDAO getGameDAO() {
        return new GameDAOMemory();
    }


    @Override
    public GroupDAO getGroupDAO() {
        return new GroupDAOMemory();
    }

    @Override
    public InvitationDAO getInvitationDAO() {
        return new InvitationDAOMemory();
    }

    @Override
    public OrganizerDAO getOrganizerDAO() {
        return new OrganizerDAOMemory();
    }

    @Override
    public ParticipationDAO getParticipationDAO() {
        return new ParticipationDAOMemory();
    }

    @Override
    public PlayerDAO getPlayerDAO() {
        return new PlayerDAOMemory();
    }

    @Override
    public RoundDAO getRoundDAO() {
        return new RoundDAOMemory();
    }

    @Override
    public TeamDAO getTeamDAO() {
        return new TeamDAOMemory() {
        };
    }

    @Override
    public TournamentDAO getTournamentDAO() {
        return new TournamentDAOMemory();
    }
}
