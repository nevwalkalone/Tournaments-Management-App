package com.example.managetournamentapp.view.User.RegisterOrganizer;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;


public class RegisterOrganizerViewModel extends ViewModel {

    RegisterOrganizerPresenter presenter;


    public RegisterOrganizerViewModel() {

        presenter = new RegisterOrganizerPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser());
    }

    public RegisterOrganizerPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}