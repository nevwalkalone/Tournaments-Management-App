package com.example.managetournamentapp.view.HomePage;

import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentPresenter;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentView;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HomePagePresenterTest {

    private HomePagePresenter presenter;
    private HomePageView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new HomePageViewStub();
        presenter = new HomePagePresenter();

        presenter.setView(view);
    }

    @Test
    public void testActions() {
        presenter.onBrowseAction();
        Assert.assertTrue(((HomePageViewStub) view).onBrowse);

        presenter.onConnectAction();
        Assert.assertTrue(((HomePageViewStub) view).onConnect);

        presenter.onLogInAction();
        Assert.assertTrue(((HomePageViewStub) view).onLogin);

        presenter.onOrganizerRegisterAction();
        Assert.assertTrue(((HomePageViewStub) view).onOrganizerRegister);

        presenter.onPlayerRegisterAction();
        Assert.assertTrue(((HomePageViewStub) view).onPlayerRegister);

        presenter.onRegisterAction();
        Assert.assertTrue(((HomePageViewStub) view).onRegister);
    }
}