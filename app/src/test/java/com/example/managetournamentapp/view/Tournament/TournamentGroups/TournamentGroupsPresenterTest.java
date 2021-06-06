package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Tournament.RoundGames.RoundGamesPresenter;
import com.example.managetournamentapp.view.Tournament.RoundGames.RoundGamesView;
import com.example.managetournamentapp.view.Tournament.RoundGames.RoundGamesViewStub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TournamentGroupsPresenterTest {

    private TournamentGroupsPresenter presenter;
    private TournamentGroupsView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new TournamentGroupsViewStub();
        presenter = new TournamentGroupsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());

        presenter.setView(view);
    }

    @Test
    public void findTournamentInfo() {
        presenter.findTournamentInfo("TOURNOUA1");
    }

    @Test
    public void onGroup() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onGroup(0);
    }

    @Test
    public void onGames() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onGames(0);
    }

    @Test
    public void onRankings() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onRankings(0);
    }

    @Test
    public void findAccess() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.findAccess();
    }
}