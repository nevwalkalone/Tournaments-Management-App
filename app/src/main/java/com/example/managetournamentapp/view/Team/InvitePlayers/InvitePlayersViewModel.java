package com.example.managetournamentapp.view.Team.InvitePlayers;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;

public class InvitePlayersViewModel extends ViewModel {
    InvitePlayersPresenter presenter;

    public InvitePlayersViewModel() {
        presenter = new InvitePlayersPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
    }

    public InvitePlayersPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
