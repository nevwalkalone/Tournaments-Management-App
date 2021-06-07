package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrganizerPagePresenterTest {
    private OrganizerPagePresenter presenter;
    private OrganizerPageView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new OrganizerPageViewStub();
        presenter = new OrganizerPagePresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
        presenter.setOrganizer(new OrganizerDAOMemory().findByTitle("ESKA"));


        presenter.setView(view);
    }

    @Test
    public void findOrganizer() {
        presenter.findOrganizerInfo("ESKA");
        Assert.assertEquals("ESKA", presenter.getOrganizerTitle());
    }

    @Test
    public void changePages() {

        presenter.onOrganizerAccount();
        Assert.assertTrue(((OrganizerPageViewStub) view).onOrganizer);

        presenter.onOrganizerTournaments();
        Assert.assertTrue(((OrganizerPageViewStub) view).onTournaments);

        presenter.onNoLogOut();
        Assert.assertTrue(((OrganizerPageViewStub) view).onNoLogout);

        presenter.onYesLogOut();
        Assert.assertTrue(new MemoryLoggedInUser().getUser() == null);
    }

    @Test
    public void logoutOrganizer() {
        presenter.onLogOut();
        Assert.assertTrue(((OrganizerPageViewStub) view).onLogConfirmation);
    }

}