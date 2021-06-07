package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;

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
        presenter.setOrganizer(new OrganizerDAOMemory().findByTitle("ESKA"));

        presenter.setView(view);
    }

    @Test
    public void findOrganizer() {
        //presenter.findOrganizerInfo();
    }

    @Test
    public void changePages() {

        presenter.onOrganizerAccount();
        presenter.onOrganizerTournaments();
    }

    @Test
    public void logoutOrganizer() {
        presenter.onLogOut();

    }
}