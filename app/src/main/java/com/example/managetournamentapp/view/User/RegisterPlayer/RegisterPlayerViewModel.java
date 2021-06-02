package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;


public class RegisterPlayerViewModel extends ViewModel {

    RegisterPlayerPresenter presenter;


    public RegisterPlayerViewModel() {
        presenter = new RegisterPlayerPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser());
        presenter.setPlayerDAO(new PlayerDAOMemory());
    }

    public RegisterPlayerPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}