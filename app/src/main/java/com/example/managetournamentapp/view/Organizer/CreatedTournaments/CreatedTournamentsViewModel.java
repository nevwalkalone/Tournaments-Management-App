package com.example.managetournamentapp.view.Organizer.CreatedTournaments;
import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.CreatedTournamentsPresenter;


public class CreatedTournamentsViewModel extends ViewModel {
    CreatedTournamentsPresenter presenter;

    public CreatedTournamentsViewModel() {
        presenter = new CreatedTournamentsPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory() );
        presenter.setOrganizerDAO( new OrganizerDAOMemory() );
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
