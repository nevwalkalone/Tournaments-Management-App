package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class TournamentInfoViewModel extends ViewModel {
    TournamentInfoPresenter presenter;

    public TournamentInfoViewModel(){
        presenter = new TournamentInfoPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
        presenter.setTournamentDAO(new TournamentDAOMemory());

    }
    public TournamentInfoPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
