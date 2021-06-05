package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class TournamentRoundsViewModel extends ViewModel {
    TournamentRoundsPresenter presenter;

    public TournamentRoundsViewModel(){
        presenter = new TournamentRoundsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    public TournamentRoundsPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }



}
