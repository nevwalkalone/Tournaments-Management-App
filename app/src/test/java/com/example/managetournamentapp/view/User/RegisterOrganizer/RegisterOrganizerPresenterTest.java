package com.example.managetournamentapp.view.User.RegisterOrganizer;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegisterOrganizerPresenterTest {

    private RegisterOrganizerPresenter presenter;
    private RegisterOrganizerView view;

    @Before
    public void setup(){
        new MemoryInitializer().prepareData();
        view = new RegisterOrganizerViewStub();
        presenter = new RegisterOrganizerPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser());
        presenter.setOrganizerDAO( new OrganizerDAOMemory());
        presenter.setView(view);

    }


    @Test
    public void createNew() {

        view.setUsername("nick12");
        view.setPassword("12345");
        view.setName("nickthequick");
        view.setSurname("kalathis");
        view.setPhoneNumber("0000000000");
        view.setEmail("aaaa@aaaa");
        view.setBirthdate("11/11/2000");
        view.setTitle("veryquick");

        int organizers1 = new OrganizerDAOMemory().findAll().size();
        presenter.handleOrganizerData();
        int organizers2 = new OrganizerDAOMemory().findAll().size();
        Assert.assertEquals(organizers1+1,organizers2);

    }


}