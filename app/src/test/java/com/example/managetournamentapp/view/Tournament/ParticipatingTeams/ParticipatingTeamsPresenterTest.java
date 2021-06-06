package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationPresenter;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationView;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParticipatingTeamsPresenterTest {

    private ParticipatingTeamsPresenter presenter;
    private ParticipatingTeamsView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new ParticipatingTeamsViewStub();
        presenter = new ParticipatingTeamsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setView(view);

    }

    @Test
    public void findParticipatingTeams(){
        presenter.findParticipatingTeams("TOURNOUA1");
        Assert.assertEquals(8, presenter.getResults().size());
        Assert.assertTrue(presenter.getResults().contains(new TeamDAOMemory().find("Celtic0")));

    }

    @Test
    public void changePage(){
        presenter.onTeamSelected(new TeamDAOMemory().find("Celtic0"));

    }
}