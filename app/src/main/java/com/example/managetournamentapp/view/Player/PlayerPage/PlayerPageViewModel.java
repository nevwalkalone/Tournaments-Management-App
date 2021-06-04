package com.example.managetournamentapp.view.Player.PlayerPage;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class PlayerPageViewModel extends ViewModel {

    PlayerPagePresenter presenter;

    public PlayerPageViewModel() {
        presenter = new PlayerPagePresenter();
        presenter.setPlayerDAO( new PlayerDAOMemory());
    }

    public PlayerPagePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reason
        presenter.clearView();
    }
}
