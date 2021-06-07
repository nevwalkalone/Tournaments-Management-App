package com.example.managetournamentapp.view.Player.ReceivedInvites;

import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoPresenter;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoView;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceivedInvitesPresenterTest {

    private ReceivedInvitesPresenter presenter;
    private ReceivedInvitesView view;
    private Player testPlayer;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new ReceivedInvitesViewStub();
        presenter = new ReceivedInvitesPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());

        presenter.setView(view);
    }

    @Test
    public void findInvites() {
        presenter.findInvites("gioza");
        Assert.assertEquals("gioza", presenter.getPlayerName());

    }

    @Test
    public void testActions() {
        presenter.onTeamPageClick();
        Assert.assertTrue(((ReceivedInvitesViewStub) view).onTeam);

        presenter.onHomePage();
        Assert.assertTrue(((ReceivedInvitesViewStub) view).onHome);

    }

    @Test
    public void getInvitations() {
        presenter.findInvites("gioza");
        Assert.assertEquals(1, presenter.getInvites().size());
        Assert.assertEquals("Celtic10", presenter.getInvites().get(0).getTeam().getName());

    }

    @Test
    public void declineInvite() {
        testPlayer = new PlayerDAOMemory().find("gioza");
        presenter.findInvites("gioza");
        presenter.declineInvitation(testPlayer.getInvitesReceived().get(0));
        presenter.findInvites("gioza");
        Assert.assertEquals(testPlayer.getInvitesReceived().size(), presenter.getInvites().size());

    }

    @Test
    public void acceptInvite() {
        testPlayer = new PlayerDAOMemory().find("gioza");
        presenter.findInvites("gioza");
        presenter.acceptInvitation(testPlayer.getInvitesReceived().get(0));
        presenter.findInvites("gioza");
        Assert.assertEquals(testPlayer.getInvitesReceived().size(), presenter.getInvites().size());

    }
}