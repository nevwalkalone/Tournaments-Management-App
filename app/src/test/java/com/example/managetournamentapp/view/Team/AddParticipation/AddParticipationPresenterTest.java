package com.example.managetournamentapp.view.Team.AddParticipation;

import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddParticipationPresenterTest {
    private AddParticipationPresenter presenter;
    private AddParticipationView view;
    private Team team;

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        view = new AddParticipationViewStub();
        presenter = new AddParticipationPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory() );
        presenter.setTeamDAO( new TeamDAOMemory() );
        presenter.setView(view);

        team = new TeamDAOMemory().find("Celtic1");
        presenter.findTournaments( team.getName() );
    }

    @Test
    public void addParticipation(){
        Tournament tournament = presenter.getResults().get(0);
        int number1 = team.getParticipations().size();

        presenter.onTournamentPage(tournament.getTitle());
        Assert.assertEquals(number1 , team.getParticipations().size() );

        presenter.onAddParticipation(tournament.getTitle());
        Assert.assertEquals(number1+1 , team.getParticipations().size() );

        presenter.onStartPartTournaments();
        Assert.assertEquals(number1+1 , team.getParticipations().size() );

    }


}