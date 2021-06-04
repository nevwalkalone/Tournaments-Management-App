package com.example.managetournamentapp.view.User.RegisterOrganizer;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;


public class RegisterOrganizerViewModel extends ViewModel {

    RegisterOrganizerPresenter presenter;


    public RegisterOrganizerViewModel() {

        presenter = new RegisterOrganizerPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser());
        presenter.setOrganizerDAO( new OrganizerDAOMemory());
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