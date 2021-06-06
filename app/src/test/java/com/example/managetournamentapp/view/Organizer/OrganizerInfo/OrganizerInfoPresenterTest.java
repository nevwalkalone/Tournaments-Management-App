package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentPresenter;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentView;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizerInfoPresenterTest {

    private OrganizerInfoPresenter presenter;
    private OrganizerInfoView view;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new OrganizerInfoViewStub();
        presenter = new OrganizerInfoPresenter();
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
        presenter.setOrganizer(new OrganizerDAOMemory().findByTitle("ESKA"));

        presenter.setView(view);
    }

    @Test
    public void findExisting() {
        presenter.findOrganizerInfo();
    }

    @Test
    public void deleteOrganizer() {
        // Can't delete case
        presenter.onDeleteOrganizer();

        // can delete case
        presenter.setOrganizer(new OrganizerDAOMemory().findByTitle("ESKANA"));
        presenter.onDeleteOrganizer();
    }

    @Test
    public void editOrganizer() {
        presenter.onEditOrganizer();

    }
}