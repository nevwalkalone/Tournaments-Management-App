package com.example.managetournamentapp.view.Player.PlayerPage;

import androidx.lifecycle.ViewModel;

public class PlayerPageViewModel extends ViewModel {

    PlayerPagePresenter presenter;

    public PlayerPageViewModel() {
        super();
        presenter = new PlayerPagePresenter();
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
