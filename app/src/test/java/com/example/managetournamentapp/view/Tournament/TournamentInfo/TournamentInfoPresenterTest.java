package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Tournament.TournamentGroups.TournamentGroupsPresenter;
import com.example.managetournamentapp.view.Tournament.TournamentGroups.TournamentGroupsView;
import com.example.managetournamentapp.view.Tournament.TournamentGroups.TournamentGroupsViewStub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TournamentInfoPresenterTest {

    private TournamentInfoPresenter presenter;
    private TournamentInfoView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new TournamentInfoViewStub();
        presenter = new TournamentInfoPresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setTournamentDAO(new TournamentDAOMemory());

        presenter.setView(view);
    }

    @Test
    public void findTournamentInfo() {
        presenter.findTournamentInfo("TOURNOUA1");
    }

    @Test
    public void findAccess() {
        presenter.findAccess();

        // SET ORGANIZER AS LOGGED IN USER
        new MemoryLoggedInUser().setUser(new OrganizerDAOMemory().findByTitle("ESKA"));
        presenter.findAccess();
    }

    @Test
    public void testDeleteTournament() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onDeleteTournament();

        // SET ORGANIZER AS LOGGED IN USER
        new MemoryLoggedInUser().setUser(new OrganizerDAOMemory().findByTitle("ESKA"));
        presenter.onDeleteTournament();

        // DELETE A TOURNAMENT WITH NO PARTICIPATION
        presenter.findTournamentInfo("NBA");
        presenter.onDeleteTournament();

    }

    @Test
    public void testEditTournament() {
        presenter.findTournamentInfo("TOURNOUA1");
        presenter.onEditTournament();

        // SET ORGANIZER AS LOGGED IN USER
        new MemoryLoggedInUser().setUser(new OrganizerDAOMemory().findByTitle("ESKA"));
        presenter.onEditTournament();

        // EDIT A TOURNAMENT WITH NO PARTICIPATION
        presenter.findTournamentInfo("NBA");
        presenter.onEditTournament();

    }

    @Test
    public void testButtons() {
        presenter.onYesDeleteTournament();
        presenter.onNoDeleteTournament();

    }
}