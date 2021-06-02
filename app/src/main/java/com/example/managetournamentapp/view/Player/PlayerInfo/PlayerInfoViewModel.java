package com.example.managetournamentapp.view.Player.PlayerInfo;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;


public class PlayerInfoViewModel extends ViewModel {
    PlayerInfoPresenter presenter;

    public PlayerInfoViewModel() {
        super();
        presenter = new PlayerInfoPresenter();
        presenter.setPlayer( (new MemoryLoggedInUser()).getUser()  );
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
    }

    public PlayerInfoPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }


}
