package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class ParticipatingTeamsViewModel extends ViewModel{
    ParticipatingTeamsPresenter presenter;

    public ParticipatingTeamsViewModel() {
        presenter = new ParticipatingTeamsPresenter();
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    public ParticipatingTeamsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }


}
