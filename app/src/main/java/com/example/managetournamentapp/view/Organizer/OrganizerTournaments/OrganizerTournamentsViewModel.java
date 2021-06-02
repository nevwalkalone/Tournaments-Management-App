package com.example.managetournamentapp.view.Organizer.OrganizerTournaments;
import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;


public class OrganizerTournamentsViewModel extends ViewModel {
    OrganizerTournamentsPresenter presenter;

    public OrganizerTournamentsViewModel() {
        presenter = new OrganizerTournamentsPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory() );
        presenter.setOrganizerDAO( new OrganizerDAOMemory() );
    }

    public OrganizerTournamentsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }


}
