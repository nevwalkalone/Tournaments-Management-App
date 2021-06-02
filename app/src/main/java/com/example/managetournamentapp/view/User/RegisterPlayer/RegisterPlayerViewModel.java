package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;


public class RegisterPlayerViewModel extends ViewModel {

    RegisterPlayerPresenter presenter;


    public RegisterPlayerViewModel() {
        presenter = new RegisterPlayerPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser());
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