package com.example.managetournamentapp.view.Team.ParticipatingTournaments;
import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class ParticipatingTournamentsViewModel extends ViewModel {
    ParticipatingTournamentsPresenter presenter;

    public ParticipatingTournamentsViewModel() {
        presenter = new ParticipatingTournamentsPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory());
        presenter.setTeamDAO(new TeamDAOMemory());
    }

    public ParticipatingTournamentsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }


}