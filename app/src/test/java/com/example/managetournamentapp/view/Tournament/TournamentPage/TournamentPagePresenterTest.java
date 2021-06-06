package com.example.managetournamentapp.view.Tournament.TournamentPage;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Tournament.TournamentInfo.TournamentInfoPresenter;
import com.example.managetournamentapp.view.Tournament.TournamentInfo.TournamentInfoView;
import com.example.managetournamentapp.view.Tournament.TournamentInfo.TournamentInfoViewStub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TournamentPagePresenterTest {

    private TournamentPagePresenter presenter;
    private TournamentPageView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new TournamentPageViewStub();
        presenter = new TournamentPagePresenter();

        presenter.setView(view);
    }

    @Test
    public void testActions() {
       presenter.onTournamentGames();
       presenter.onTournamentInfo();
       presenter.onTournamentTeams();

    }
}