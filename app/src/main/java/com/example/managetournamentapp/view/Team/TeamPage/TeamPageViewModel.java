package com.example.managetournamentapp.view.Team.TeamPage;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;


public class TeamPageViewModel extends ViewModel {
    TeamPagePresenter presenter;

    public TeamPageViewModel() {
        super();
        presenter = new TeamPagePresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
        presenter.setTeamDAO(new TeamDAOMemory());
    }

    public TeamPagePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
