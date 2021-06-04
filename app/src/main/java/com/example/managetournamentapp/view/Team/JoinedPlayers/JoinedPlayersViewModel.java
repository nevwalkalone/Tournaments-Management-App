package com.example.managetournamentapp.view.Team.JoinedPlayers;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.view.Team.InvitePlayers.InvitePlayersPresenter;

public class JoinedPlayersViewModel extends ViewModel {

    JoinedPlayersPresenter presenter;

    public JoinedPlayersViewModel() {
        presenter = new JoinedPlayersPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());
    }

    public JoinedPlayersPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
