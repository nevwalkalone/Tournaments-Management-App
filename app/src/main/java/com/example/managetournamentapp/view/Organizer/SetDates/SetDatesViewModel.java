package com.example.managetournamentapp.view.Organizer.SetDates;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Team.JoinedPlayers.JoinedPlayersPresenter;

public class SetDatesViewModel extends ViewModel {

    SetDatesPresenter presenter;

    public SetDatesViewModel() {
        presenter = new SetDatesPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    public SetDatesPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
