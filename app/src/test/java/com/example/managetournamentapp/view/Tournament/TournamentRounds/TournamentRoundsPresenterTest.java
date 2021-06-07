package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageViewStub;
import com.example.managetournamentapp.view.Tournament.TournamentInfo.TournamentInfoViewStub;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPagePresenter;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageView;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TournamentRoundsPresenterTest {

    private TournamentRoundsPresenter presenter;
    private TournamentRoundsView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new TournamentRoundsViewStub();
        presenter = new TournamentRoundsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());

        presenter.setView(view);
    }

    @Test
    public void testGroup() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onGroups();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onGroups);

    }

    @Test
    public void test8() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.on8();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onRound);

    }

    @Test
    public void test16() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.on16();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onRound);

    }

    @Test
    public void testSemiFinals() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onSemifinals();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onRound);
    }

    @Test
    public void testFinal() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onFinal();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onRound);
    }

    @Test
    public void findAccess() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.findAccess();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onChange);

    }

    @Test
    public void testAction(){
        new MemoryLoggedInUser().setUser(new OrganizerDAOMemory().findByTitle("ESKA"));
        presenter.onHomePage();
        Assert.assertTrue(((TournamentRoundsViewStub) view).onHome);
    }


}