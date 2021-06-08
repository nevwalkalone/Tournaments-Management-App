package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class TournamentInfoViewModel extends ViewModel {
    TournamentInfoPresenter presenter;

    /**
     * the constructor
     */
    public TournamentInfoViewModel(){
        presenter = new TournamentInfoPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    /** get the presenter
     * @return the TournamentInfoPresenter instance
     */
    public TournamentInfoPresenter getPresenter(){
        return presenter;
    }

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
