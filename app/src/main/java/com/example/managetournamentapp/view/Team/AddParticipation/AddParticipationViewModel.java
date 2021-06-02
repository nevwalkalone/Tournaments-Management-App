package com.example.managetournamentapp.view.Team.AddParticipation;
import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class AddParticipationViewModel extends ViewModel {
    AddParticipationPresenter presenter;

    public AddParticipationViewModel(){
        presenter = new AddParticipationPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory() );
        presenter.setTeamDAO( new TeamDAOMemory() );
    }

    public AddParticipationPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
