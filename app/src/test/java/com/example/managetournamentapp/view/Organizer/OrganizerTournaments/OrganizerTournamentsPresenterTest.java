package com.example.managetournamentapp.view.Organizer.OrganizerTournaments;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrganizerTournamentsPresenterTest {
    private OrganizerTournamentsPresenter presenter;
    private OrganizerTournamentsView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new OrganizerTournamentsViewStub();
        presenter = new OrganizerTournamentsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setOrganizerDAO(new OrganizerDAOMemory());

        presenter.setView(view);
    }

    @Test
    public void findOrganizerTournaments() {
        // NULL
        presenter.findCreatedTournaments("EPSA");

        // NOT NULL
        presenter.findCreatedTournaments("ESKA");
        Assert.assertEquals(presenter.getResults().get(0), new TournamentDAOMemory().find("TOURNOUA1"));
        Assert.assertEquals(2, presenter.getResults().size());
        Assert.assertEquals("TOURNOUA1", presenter.getResults().get(0).getTitle());
    }

    @Test
    public void changePage() {
        presenter.onAddTournament();

    }


}