package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

/**
 * Developed for the purposes of University Lesson "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

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