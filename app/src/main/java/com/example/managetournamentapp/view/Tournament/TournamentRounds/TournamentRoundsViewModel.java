package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class TournamentRoundsViewModel extends ViewModel {
    TournamentRoundsPresenter presenter;

    public TournamentRoundsViewModel(){
        super();
        presenter = new TournamentRoundsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    public TournamentRoundsPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reasons
        presenter.clearView();
    }



}
