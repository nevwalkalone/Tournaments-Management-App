package com.example.managetournamentapp.view.HomePage;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class HomePageViewModel extends ViewModel {

    HomePagePresenter presenter;

    public HomePageViewModel() {
        presenter = new HomePagePresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
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