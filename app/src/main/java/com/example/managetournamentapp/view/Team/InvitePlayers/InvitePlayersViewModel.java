package com.example.managetournamentapp.view.Team.InvitePlayers;
import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class InvitePlayersViewModel extends ViewModel {
    InvitePlayersPresenter presenter;

    public InvitePlayersViewModel() {
        presenter = new InvitePlayersPresenter();
        presenter.setPlayerDAO( new PlayerDAOMemory ());
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
