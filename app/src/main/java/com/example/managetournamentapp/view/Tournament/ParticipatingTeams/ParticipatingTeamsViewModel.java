package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;
import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;

public class ParticipatingTeamsViewModel extends ViewModel{
    ParticipatingTeamsPresenter presenter;

    public ParticipatingTeamsViewModel() {
        presenter = new ParticipatingTeamsPresenter();
        TeamDAOMemory teamDAOMemory = new TeamDAOMemory();
        presenter.setTeamDAO(teamDAOMemory);
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
