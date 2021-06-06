package com.example.managetournamentapp.view.Team.TeamInfo;

import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.User.RegisterOrganizer.RegisterOrganizerPresenter;
import com.example.managetournamentapp.view.User.RegisterOrganizer.RegisterOrganizerView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamInfoPresenterTest {
    private TeamInfoPresenter presenter;
    private TeamInfoView view;
    private Team team;

    @Before
    public void setUp() {
    }

    @Test
    public void teamInfoEditable(){
        new MemoryInitializer().prepareData();
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy24"));

        view = new TeamInfoViewStub();
        presenter = new TeamInfoPresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setView(view);

        team = new TeamDAOMemory().find("Celtic8");
        presenter.findTeamInfo(team.getName());
        presenter.findAccess();

        presenter.onEditTeam();
        Assert.assertEquals( team.getColors(),"green");

        int number1 = new TeamDAOMemory().findAll().size();
        presenter.onDeleteTeam();
        Assert.assertEquals( number1, new TeamDAOMemory().findAll().size());

        team.removePlayer(team.getPlayers().get(1));
        team.removePlayer(team.getPlayers().get(1));
        presenter.onDeleteTeam();
        Assert.assertEquals( number1-1, new TeamDAOMemory().findAll().size());
    }


    @Test
    public void teamInfoUneditable(){
        new MemoryInitializer().prepareData();
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));

        view = new TeamInfoViewStub();
        presenter = new TeamInfoPresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setView(view);

        team = new TeamDAOMemory().find("Celtic0");
        presenter.findTeamInfo(team.getName());
        presenter.findAccess();

        presenter.onEditTeam();
        Assert.assertEquals( team.getColors(),"green");

        int number1 = new TeamDAOMemory().findAll().size();
        presenter.onDeleteTeam();
        Assert.assertEquals( number1, new TeamDAOMemory().findAll().size());
    }

}