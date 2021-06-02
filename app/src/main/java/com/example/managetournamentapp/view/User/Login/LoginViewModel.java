package com.example.managetournamentapp.view.User.Login;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;


public class LoginViewModel extends ViewModel {
    LoginPresenter presenter;


    public LoginViewModel() {
        presenter = new LoginPresenter();
        presenter.setOrganizerDAO( new OrganizerDAOMemory());
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
    }

    public LoginPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}