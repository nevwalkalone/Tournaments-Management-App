package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParticipatingTournamentsPresenterTest {
    private ParticipatingTournamentsPresenter presenter;
    private ParticipatingTournamentsView view;
    private Team team;

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        new MemoryLoggedInUser().setUser( new PlayerDAOMemory().find("tommy0")  );
        view = new ParticipatingTournamentsViewStub();

        presenter = new ParticipatingTournamentsPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setView(view);

    }

    @Test
    public void participatingTournaments(){
        team = new TeamDAOMemory().find("Celtic1");
        presenter.findParticipatingTournaments(team.getName());
        presenter.findAccess();
        int number1 =  team.getParticipations().size();

        Assert.assertEquals(presenter.getResults().get(0) , team.getParticipations().get(0).getTournament());

        presenter.onAddParticipation();
        Assert.assertEquals(number1, team.getParticipations().size());
    }

}