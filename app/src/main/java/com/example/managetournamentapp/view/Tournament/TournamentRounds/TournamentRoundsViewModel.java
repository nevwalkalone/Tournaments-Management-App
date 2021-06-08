package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class TournamentRoundsViewModel extends ViewModel {
    TournamentRoundsPresenter presenter;

    /**
     * the constructor
     */
    public TournamentRoundsViewModel(){
        presenter = new TournamentRoundsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    /**
     * @return the presenter instance
     */
    public TournamentRoundsPresenter getPresenter(){
        return presenter;
    }

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }



}
