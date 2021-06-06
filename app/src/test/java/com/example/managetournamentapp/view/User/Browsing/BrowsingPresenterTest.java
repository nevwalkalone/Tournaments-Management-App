package com.example.managetournamentapp.view.User.Browsing;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.User.Login.LoginPresenter;
import com.example.managetournamentapp.view.User.Login.LoginView;
import com.example.managetournamentapp.view.User.Login.LoginViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrowsingPresenterTest {

    private BrowsingPresenter presenter;
    private BrowsingView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new BrowsingViewStub();
        presenter = new BrowsingPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());

        presenter.setView(view);
    }

    @Test
    public void findAllTournaments() {
        presenter.findAllTournaments();
        Assert.assertEquals(2, presenter.getResults().size());

    }

    @Test
    public void startPage() {
        presenter.findAllTournaments();
        presenter.startTournamentPage(presenter.getResults().get(0));

    }
}