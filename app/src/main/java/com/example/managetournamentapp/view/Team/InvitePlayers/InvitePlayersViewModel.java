package com.example.managetournamentapp.view.Team.InvitePlayers;
import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class InvitePlayersViewModel extends ViewModel {
    InvitePlayersPresenter presenter;

    public InvitePlayersViewModel() {
        presenter = new InvitePlayersPresenter();
        PlayerDAOMemory playerDAOMemory = new PlayerDAOMemory ();
        presenter.setPlayerDAO(playerDAOMemory);
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
