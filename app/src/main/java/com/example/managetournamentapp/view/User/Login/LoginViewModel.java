package com.example.managetournamentapp.view.User.Login;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;


public class LoginViewModel extends ViewModel {
    LoginPresenter presenter;

    /**
     * the default constructor
     */
    public LoginViewModel() {
        presenter = new LoginPresenter();
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());
    }

    /**
     * @return the presenter instance
     */
    public LoginPresenter getPresenter() {
        return presenter;
    }

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}