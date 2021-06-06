package com.example.managetournamentapp.view.Player.PlayerPage;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoPresenter;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoView;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerPagePresenterTest {

    private PlayerPagePresenter presenter;
    private PlayerPageView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new PlayerPageViewStub();
        presenter = new PlayerPagePresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());

        presenter.setView(view);
    }

    @Test
    public void findPlayerInfo() {
        presenter.findPlayerInfo("tommy0");
        Assert.assertEquals("tomtom", presenter.getPlayerName());
    }

    @Test
    public void findAccess() {

        presenter.findAccess("tommy0");

        // if tommy0 is the logged in user!
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));
        presenter.findPlayerInfo("tommy0");
        presenter.findAccess("tommy0");

    }

    @Test
    public void testActions() {

        presenter.findPlayerInfo("tommy0");
        presenter.onLogOut();
        presenter.onPlayerAccount();
        presenter.onPlayerInvites();
        presenter.onPlayerTeams();

    }
}