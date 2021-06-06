package com.example.managetournamentapp.view.User.Browsing;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class BrowsingViewModel extends ViewModel {

    BrowsingPresenter presenter;

    public BrowsingViewModel() {
        presenter = new BrowsingPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());

    }

    public BrowsingPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
