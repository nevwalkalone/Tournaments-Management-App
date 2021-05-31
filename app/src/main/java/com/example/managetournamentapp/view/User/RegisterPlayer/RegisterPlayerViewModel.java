package com.example.managetournamentapp.view.User.RegisterPlayer;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.memoryDao.LoggenInUserDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;


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