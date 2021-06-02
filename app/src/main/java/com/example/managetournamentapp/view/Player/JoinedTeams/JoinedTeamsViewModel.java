package com.example.managetournamentapp.view.Player.JoinedTeams;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;

public class JoinedTeamsViewModel extends ViewModel{
    JoinedTeamsPresenter presenter;

    public JoinedTeamsViewModel() {
        super();
        presenter = new JoinedTeamsPresenter();
        presenter.setTeamDAO( new TeamDAOMemory());
        presenter.setPlayer( (new MemoryLoggedInUser()).getUser()  );
        presenter.setLoggedInUser( new MemoryLoggedInUser() );
    }

    public JoinedTeamsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}

