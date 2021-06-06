package com.example.managetournamentapp.view.User.Login;

import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPresenterTest {

    private LoginPresenter presenter;
    private LoginView view;

    @Before
    public void setup() {
        new MemoryInitializer().prepareData();
        view = new LoginViewStub();
        presenter = new LoginPresenter();
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());

        presenter.setView(view);
    }

    @Test
    public void loginSuccess() {
        presenter.validateCredentials();
        Assert.assertEquals(presenter.getLoggedInUser().getUser(), new PlayerDAOMemory().find("tommy0"));
    }

    @Test
    public void loginFail() {
        new PlayerDAOMemory().delete(new PlayerDAOMemory().find("tommy0"));
        presenter.validateCredentials();
        Assert.assertEquals(presenter.getLoggedInUser().getUser(), null);
    }


}