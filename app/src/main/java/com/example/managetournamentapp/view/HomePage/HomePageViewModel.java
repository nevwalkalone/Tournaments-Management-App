package com.example.managetournamentapp.view.HomePage;

import androidx.lifecycle.ViewModel;


public class HomePageViewModel extends ViewModel {

    HomePagePresenter presenter;

    public HomePageViewModel() {
        presenter = new HomePagePresenter();
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