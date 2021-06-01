package com.example.managetournamentapp.view.Player.CreateTeam;

import androidx.lifecycle.ViewModel;


public class CreateTeamViewModel extends ViewModel {
    CreateTeamPresenter presenter;


    public CreateTeamViewModel() {
        presenter = new CreateTeamPresenter();
    }

    public CreateTeamPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }




}
