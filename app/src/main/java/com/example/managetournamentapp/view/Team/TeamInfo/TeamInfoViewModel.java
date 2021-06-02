package com.example.managetournamentapp.view.Team.TeamInfo;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;

public class TeamInfoViewModel extends ViewModel {
    TeamInfoPresenter presenter;

    public TeamInfoViewModel() {
        super();
        presenter = new TeamInfoPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
        presenter.setTeamDAO(new TeamDAOMemory());
    }

    public TeamInfoPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }


}
