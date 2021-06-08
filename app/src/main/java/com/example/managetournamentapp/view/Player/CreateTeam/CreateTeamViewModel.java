package com.example.managetournamentapp.view.Player.CreateTeam;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;


public class CreateTeamViewModel extends ViewModel {
    CreateTeamPresenter presenter;

    /**
     * the default constructor
     */
    public CreateTeamViewModel() {
        presenter = new CreateTeamPresenter();
        presenter.setTeamDAO( new TeamDAOMemory());
        presenter.setPlayer( (Player) (new MemoryLoggedInUser()).getUser() );
        presenter.setPlayerDAO( new PlayerDAOMemory());
    }

    /** get the presenter
     * @return the CreateTeamPresenter instance
     */
    public CreateTeamPresenter getPresenter() {
        return presenter;
    }

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
