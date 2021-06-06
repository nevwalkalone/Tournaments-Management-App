package com.example.managetournamentapp.view.Organizer.SetDates;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;
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

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SetDatesPresenterTest {

    private SetDatesPresenter presenter;
    private SetDatesView view;
    private Tournament tournament;

    @Before
    public void setUp() throws Exception {

        new MemoryInitializer().prepareData();
        view = new SetDatesViewStub();
        presenter = new SetDatesPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setOrganizer(new OrganizerDAOMemory().findByTitle("ESKA"));

        presenter.setView(view);
        tournament = new TournamentDAOMemory().find("TOURNOUA1");
    }

    @Test
    public void findInfo() {

        ArrayList<String> basicInfo = new ArrayList<>(Arrays.asList(tournament.getTitle(), tournament.getStartDate().toString(), tournament.getFinishDate().toString(), tournament.getLocation(), tournament.getSportType().getName(), String.valueOf(tournament.getMAX_TEAMS_NUMBER()), tournament.getAgeDivision().toString(), tournament.getDescription()));
        presenter.findBasicInfo(basicInfo);
    }

    @Test
    public void testOnSaveTournament() {
        ArrayList<String> basicInfo = new ArrayList<>(Arrays.asList(tournament.getTitle(), tournament.getStartDate().toString(), tournament.getFinishDate().toString(), tournament.getLocation(), tournament.getSportType().getName(), String.valueOf(tournament.getMAX_TEAMS_NUMBER()), tournament.getAgeDivision().toString(), tournament.getDescription()));
        presenter.findBasicInfo(basicInfo);
        presenter.onSaveTournament();
    }
}