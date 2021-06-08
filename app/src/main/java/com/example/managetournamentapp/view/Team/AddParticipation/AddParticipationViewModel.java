package com.example.managetournamentapp.view.Team.AddParticipation;
import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class AddParticipationViewModel extends ViewModel {
    AddParticipationPresenter presenter;

    /**
     * the constructor
     */
    public AddParticipationViewModel(){
        presenter = new AddParticipationPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory() );
        presenter.setTeamDAO( new TeamDAOMemory() );
    }

    /** get the presenter
     * @return the AddParticipationPresenter instance
     */
    public AddParticipationPresenter getPresenter() {
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
