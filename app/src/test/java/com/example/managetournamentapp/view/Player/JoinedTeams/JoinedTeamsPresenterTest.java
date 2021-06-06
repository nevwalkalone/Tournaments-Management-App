package com.example.managetournamentapp.view.Player.JoinedTeams;

import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamPresenter;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamView;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoinedTeamsPresenterTest {

    private JoinedTeamsPresenter presenter;
    private JoinedTeamsView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new JoinedTeamsViewStub();
        presenter = new JoinedTeamsPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());


        presenter.setView(view);
    }

    @Test
    public void changePage() {

        presenter.onAddTeam();

    }

    @Test
    public void findJoinedTeams() {

        presenter.findJoinedTeams("tommy0");
        Assert.assertEquals(new TeamDAOMemory().find("Celtic0"), presenter.getResults().get(0));
        Assert.assertEquals(2, presenter.getResults().size());

    }
}