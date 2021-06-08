package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class ParticipatingTeamsViewModel extends ViewModel{
    ParticipatingTeamsPresenter presenter;

    /**
     * the constructor
     */
    public ParticipatingTeamsViewModel() {
        presenter = new ParticipatingTeamsPresenter();
        presenter.setTeamDAO(new TeamDAOMemory());
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    /** get the presenter
     * @return the ParticipatingTeamsPresenter instance
     */
    public ParticipatingTeamsPresenter getPresenter() {
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
