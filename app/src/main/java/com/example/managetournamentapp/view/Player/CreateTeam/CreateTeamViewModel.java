package com.example.managetournamentapp.view.Player.CreateTeam;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;


public class CreateTeamViewModel extends ViewModel {
    CreateTeamPresenter presenter;


    public CreateTeamViewModel() {
        presenter = new CreateTeamPresenter();
        presenter.setTeamDAO( new TeamDAOMemory());
        presenter.setPlayer( (Player) (new MemoryLoggedInUser()).getUser() );
        presenter.setPlayerDAO( new PlayerDAOMemory());
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
