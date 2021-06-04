package com.example.managetournamentapp.view.Player.ReceivedInvites;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class ReceivedInvitesViewModel extends ViewModel {

    ReceivedInvitesPresenter presenter;

    public ReceivedInvitesViewModel() {
        presenter = new ReceivedInvitesPresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setPlayerDAO(new PlayerDAOMemory());
    }

    public ReceivedInvitesPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
