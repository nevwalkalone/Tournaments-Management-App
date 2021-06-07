package com.example.managetournamentapp.view.Player.CreateTeam;

import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentPresenter;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentView;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentViewStub;
import com.example.managetournamentapp.view.Organizer.SetDates.SetDatesViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateTeamPresenterTest {

    private CreateTeamPresenter presenter;
    private CreateTeamView view;
    private Player captain;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new CreateTeamViewStub();
        presenter = new CreateTeamPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
        captain = new PlayerDAOMemory().find("tommy0");
        new MemoryLoggedInUser().setUser(captain);
        presenter.setPlayer(new PlayerDAOMemory().find("tommy0"));


        presenter.setView(view);
    }

    @Test
    public void createNew() {

        view.setTeamName("RealMadrid");
        view.setTeamColors("white");
        view.setSportType(2);
        presenter.onSaveTeam();
        Assert.assertTrue(((CreateTeamViewStub) view).onSave);

        Assert.assertEquals(presenter.getSportTypes().get(2), "Football5v5");

    }

    @Test
    public void changeExisting() {
        String teamName = "Celtic10";
        presenter.showPreviousInfo(teamName);
        Assert.assertTrue(((CreateTeamViewStub) view).onLock);

        view.setTeamName("Bulls");
        presenter.onSaveTeam();

        String newName = new TeamDAOMemory().find("Bulls").getName();
        Assert.assertEquals("Bulls", newName);
    }

    @Test
    public void testAction() {
        presenter.onHomePage();
        Assert.assertTrue(((CreateTeamViewStub) view).onHome);

    }


}