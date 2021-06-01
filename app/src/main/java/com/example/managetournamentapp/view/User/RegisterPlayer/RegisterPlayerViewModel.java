package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.lifecycle.ViewModel;


public class RegisterPlayerViewModel extends ViewModel {

    RegisterPlayerPresenter presenter;


    public RegisterPlayerViewModel() {
        presenter = new RegisterPlayerPresenter();
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