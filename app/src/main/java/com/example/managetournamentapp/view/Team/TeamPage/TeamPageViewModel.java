package com.example.managetournamentapp.view.Team.TeamPage;

import androidx.lifecycle.ViewModel;


public class TeamPageViewModel extends ViewModel {

    TeamPagePresenter presenter;

    public TeamPageViewModel() {
        super();
        presenter = new TeamPagePresenter();
    }

    public TeamPagePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reasons
        presenter.clearView();
    }

}
