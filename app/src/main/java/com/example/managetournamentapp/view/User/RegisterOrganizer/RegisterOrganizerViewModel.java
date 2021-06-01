package com.example.managetournamentapp.view.User.RegisterOrganizer;

import androidx.lifecycle.ViewModel;


public class RegisterOrganizerViewModel extends ViewModel {

    RegisterOrganizerPresenter presenter;


    public RegisterOrganizerViewModel() {

        presenter = new RegisterOrganizerPresenter();
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