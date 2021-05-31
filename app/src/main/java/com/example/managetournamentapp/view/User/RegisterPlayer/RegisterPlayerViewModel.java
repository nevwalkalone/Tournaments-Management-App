package com.example.managetournamentapp.view.User.RegisterPlayer;

import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.HomePage.HomePagePresenter;

public class RegisterPlayerViewModel extends ViewModel {

    RegisterPlayerPresenter presenter;
    private Intent activity;

    public RegisterPlayerViewModel(Intent intent) {
        this.activity = intent;
        presenter = new RegisterPlayerPresenter();
        TournamentDAOMemory tournamentDAOMemory = new TournamentDAOMemory();
        presenter.setTournamentDAO(tournamentDAOMemory);
    }

    public RegisterPlayerPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

    public int getPlayerID() {
        if (activity.hasExtra("PLAYER_ID"))
            return activity.getExtras

        return this.getIntent().getExtras().getInt("borrower_id") : null;
    }
}