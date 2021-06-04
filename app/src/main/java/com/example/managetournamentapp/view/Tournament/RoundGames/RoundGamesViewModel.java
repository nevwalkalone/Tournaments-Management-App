package com.example.managetournamentapp.view.Tournament.RoundGames;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class RoundGamesViewModel extends ViewModel {
    RoundGamesPresenter presenter;

    public RoundGamesViewModel(){
        presenter = new RoundGamesPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());

    }

    public RoundGamesPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
