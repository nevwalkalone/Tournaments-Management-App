package com.example.managetournamentapp.view.Team.InvitePlayers;

import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvitePlayersPresenterTest {
    InvitePlayersPresenter presenter;
    InvitePlayersView view;
    private Team team;

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        view = new InvitePlayersViewStub();
        presenter = new InvitePlayersPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setView(view);

        team = new TeamDAOMemory().find("Celtic0");
        presenter.findPlayers(team.getName());
    }

    @Test
    public void invitePlayers(){
        Player player = presenter.getResults().get(0);

        int number1 = player.getInvitesReceived().size();
        int number2 = team.getPlayers().size();

        presenter.inviteNewPlayer(team.getName(), player);
        Assert.assertEquals(number1+1, player.getInvitesReceived().size());

        presenter.closePopAction();
        presenter.displayPopAction(0,"",0,0, true);
        Assert.assertEquals(number1+1, player.getInvitesReceived().size());

        presenter.onPlayerAccountSelected(player);
        presenter.restartActivity();
        Assert.assertEquals(number1+1, player.getInvitesReceived().size());
        Assert.assertEquals(number2, team.getPlayers().size());
    }

    @Test
    public void testAction(){
        new MemoryLoggedInUser().setUser(new PlayerDAOMemory().find("tommy0"));
        presenter.onHomePage();
        Assert.assertTrue(((InvitePlayersViewStub) view).onHome);
    }



}