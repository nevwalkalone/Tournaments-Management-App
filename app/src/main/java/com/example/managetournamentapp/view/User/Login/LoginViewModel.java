package com.example.managetournamentapp.view.User.Login;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerPresenter;

public class LoginViewModel extends ViewModel {
    LoginPresenter presenter;


    public LoginViewModel() {

        presenter = new LoginPresenter();
    }

    public LoginPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
//        presenter.clearView();
    }
}