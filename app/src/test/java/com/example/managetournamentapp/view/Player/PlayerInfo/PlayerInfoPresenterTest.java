package com.example.managetournamentapp.view.Player.PlayerInfo;

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

public class PlayerInfoPresenterTest {

    private PlayerInfoPresenter presenter;
    private PlayerInfoView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new PlayerInfoViewStub();
        presenter = new PlayerInfoPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());

        presenter.setView(view);
    }


    @Test
    public void findAccess() {

        presenter.findAccess();
        presenter.findPlayerInfo("tommy0");

        // if tommy0 selects to see his info page!
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));
        presenter.findPlayerInfo("tommy0");
        presenter.findAccess();
        Assert.assertTrue(((PlayerInfoViewStub) view).onChange);

    }

    @Test
    public void deletePlayerInfo() {

        // CAN'T DELETE
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));
        presenter.findPlayerInfo("tommy0");
        presenter.onDeletePlayer();
        Assert.assertTrue(new MemoryLoggedInUser().getUser() != null);

        // CAN DELETE
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy28"));
        presenter.findPlayerInfo("tommy28");
        presenter.onDeletePlayer();



        presenter.onNoDeletePlayer();
        Assert.assertTrue(new MemoryLoggedInUser().getUser() != null);

        presenter.onYesDeletePlayer();
        Assert.assertTrue(new MemoryLoggedInUser().getUser() == null);
        Assert.assertTrue(((PlayerInfoViewStub) view).onDelete);
    }

    @Test
    public void editPlayer() {
        presenter.onEditPlayer();
        Assert.assertTrue(((PlayerInfoViewStub) view).onEdit);
    }

}