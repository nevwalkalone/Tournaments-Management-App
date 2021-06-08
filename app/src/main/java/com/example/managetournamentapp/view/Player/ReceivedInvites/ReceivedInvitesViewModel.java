package com.example.managetournamentapp.view.Player.ReceivedInvites;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class ReceivedInvitesViewModel extends ViewModel {
    ReceivedInvitesPresenter presenter;

    /**
     * the constructor
     */
    public ReceivedInvitesViewModel() {
        presenter = new ReceivedInvitesPresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setPlayerDAO(new PlayerDAOMemory());
    }

    /** get the presenter
     * @return the ReceivedInvitesPresenter instance
     */
    public ReceivedInvitesPresenter getPresenter() {
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
