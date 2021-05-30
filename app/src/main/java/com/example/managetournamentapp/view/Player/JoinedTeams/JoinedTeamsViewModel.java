package com.example.managetournamentapp.view.Player.JoinedTeams;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;

public class JoinedTeamsViewModel extends ViewModel{
    JoinedTeamsPresenter presenter;

    public JoinedTeamsViewModel() {
        presenter = new JoinedTeamsPresenter();
        TeamDAOMemory teamDAOMemory = new TeamDAOMemory();
        presenter.setTeamDAO(teamDAOMemory);
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

