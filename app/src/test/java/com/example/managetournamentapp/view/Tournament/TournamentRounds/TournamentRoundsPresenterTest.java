package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPagePresenter;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageView;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageViewStub;

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
    public void testActions() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.on8();
        presenter.on16();
        presenter.onFinal();
        presenter.onSemifinals();
        presenter.onGroups();

    }

    @Test
    public void findAccess() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.findAccess();

    }
}