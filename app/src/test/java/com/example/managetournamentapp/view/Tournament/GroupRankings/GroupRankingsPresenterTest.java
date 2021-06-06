package com.example.managetournamentapp.view.Tournament.GroupRankings;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationPresenter;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationView;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupRankingsPresenterTest {

    private GroupRankingsPresenter presenter;
    private GroupRankingsView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new GroupRankingsViewStub();
        presenter = new GroupRankingsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setView(view);

    }

    @Test
    public void testFindTeams() {
        presenter.findTeams("TOURNOUA1", 0);

        Assert.assertTrue(presenter.getResults().contains(new TeamDAOMemory().find("Celtic0")));

    }

}