package com.example.managetournamentapp.view.Team.ParticipatingTournaments;
import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class ParticipatingTournamentsViewModel extends ViewModel {
    ParticipatingTournamentsPresenter presenter;

    public ParticipatingTournamentsViewModel() {
        presenter = new ParticipatingTournamentsPresenter();
        TournamentDAOMemory tournamentDAOMemory = new TournamentDAOMemory();
        presenter.setTournamentDAO(tournamentDAOMemory);
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