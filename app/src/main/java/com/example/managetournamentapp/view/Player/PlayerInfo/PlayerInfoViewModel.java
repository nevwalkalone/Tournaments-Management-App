package com.example.managetournamentapp.view.Player.PlayerInfo;

import androidx.lifecycle.ViewModel;


public class PlayerInfoViewModel extends ViewModel {
    PlayerInfoPresenter presenter;

    public PlayerInfoViewModel() {
        super();
        presenter = new PlayerInfoPresenter();
    }

    public PlayerInfoPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reason
        presenter.clearView();
    }


}
