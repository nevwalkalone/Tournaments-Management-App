package com.example.managetournamentapp.view.User.Browsing;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class BrowsingViewModel extends ViewModel {

    BrowsingPresenter presenter;

    /**
     * the constructor
     */
    public BrowsingViewModel() {
        presenter = new BrowsingPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());

    }

    /**
     *
     * @return the presenter instance
     */
    public BrowsingPresenter getPresenter() {
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
