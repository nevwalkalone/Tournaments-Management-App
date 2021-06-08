package com.example.managetournamentapp.view.Tournament.RoundGames;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.ParticipatingTeamsPresenter;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.ParticipatingTeamsView;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.ParticipatingTeamsViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundGamesPresenterTest {

    private RoundGamesPresenter presenter;
    private RoundGamesView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new RoundGamesViewStub();
        presenter = new RoundGamesPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setView(view);

    }

    @Test
    public void findGames() {
        presenter.findGames("TOURNOUA1", 4, -1);
        Assert.assertEquals(2, presenter.getResults().size());

    }

    @Test
    public void onPressedTest() {
        presenter.findGames("TOURNOUA1", 4, 0);
        presenter.onPressed(presenter.getResults().get(0));
        Assert.assertFalse(((RoundGamesViewStub) view).onPop);


    }

    @Test
    public void onSaveTest() {
        presenter.findGames("TOURNOUA1", 8, 0);
        System.out.println(presenter.getResults().get(0).getTeamA());
        presenter.onSave(presenter.getResults().get(0), "2", "0");
        Assert.assertTrue(presenter.getResults().get(0).isFinished());

        //GIVE ACCESS TO ORGANIZER
        new MemoryLoggedInUser().setUser(new OrganizerDAOMemory().findByTitle("ESKA"));
        presenter.findAccess();
        presenter.onSave(presenter.getResults().get(0), "2", "0");
        Assert.assertTrue(presenter.getResults().get(0).isFinished());
    }

    @Test
    public void changePage() {
        new MemoryLoggedInUser().setUser(new OrganizerDAOMemory().findByTitle("ESKA"));
        presenter.onHomePage();
        Assert.assertTrue(((RoundGamesViewStub) view).onHome);

    }
}