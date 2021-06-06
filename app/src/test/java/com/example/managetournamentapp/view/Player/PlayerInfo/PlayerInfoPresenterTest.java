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
    public void findPlayerInfo() {
        presenter.findPlayerInfo("tommy0");

    }

    @Test
    public void findAccess() {

        presenter.findAccess();

        // if tommy0 selects to see his info page!
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));
        presenter.findPlayerInfo("tommy0");
        presenter.findAccess();

    }

    @Test
    //TODO POP DELETE TEST
    public void deletePlayerInfo() {

        // CAN'T DELETE
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));
        presenter.findPlayerInfo("tommy0");
        presenter.onDeletePlayer();

        // CAN DELETE
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy28"));
        presenter.findPlayerInfo("tommy28");
        presenter.onDeletePlayer();

        presenter.onNoDeletePlayer();

        presenter.onYesDeletePlayer();
    }

    @Test
    public void editPlayer() {
        presenter.onEditPlayer();
    }
}