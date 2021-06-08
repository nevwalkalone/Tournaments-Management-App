package com.example.managetournamentapp.view.Team.JoinedPlayers;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;


public class JoinedPlayersViewModel extends ViewModel {
    JoinedPlayersPresenter presenter;

    /**
     * the constructor
     */
    public JoinedPlayersViewModel() {
        presenter = new JoinedPlayersPresenter();
        presenter.setPlayerDAO(new PlayerDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setLoggedInUser(new MemoryLoggedInUser());
    }

    /** get the presenter
     * @return the JoinedPlayersPresenter instance
     */
    public JoinedPlayersPresenter getPresenter() {
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
