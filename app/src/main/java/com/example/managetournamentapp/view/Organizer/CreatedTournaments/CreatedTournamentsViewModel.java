package com.example.managetournamentapp.view.Organizer.CreatedTournaments;
import androidx.lifecycle.ViewModel;


import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class CreatedTournamentsViewModel extends ViewModel {
    CreatedTournamentsPresenter presenter;

    public CreatedTournamentsViewModel() {
        presenter = new CreatedTournamentsPresenter();
        TournamentDAOMemory tournamentDAOMemory = new TournamentDAOMemory();
        presenter.setTournamentDAO(tournamentDAOMemory);
    }

    public CreatedTournamentsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }


}
