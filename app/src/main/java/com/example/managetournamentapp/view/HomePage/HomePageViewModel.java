package com.example.managetournamentapp.view.HomePage;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class HomePageViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    HomePagePresenter presenter;

    public HomePageViewModel() {
        presenter = new HomePagePresenter();
        TournamentDAOMemory tournamentDAOMemory = new TournamentDAOMemory();
        presenter.setTournamentDAO(tournamentDAOMemory);
    }

    public HomePagePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}