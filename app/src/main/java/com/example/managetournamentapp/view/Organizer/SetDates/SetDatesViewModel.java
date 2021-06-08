package com.example.managetournamentapp.view.Organizer.SetDates;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public class SetDatesViewModel extends ViewModel {

    SetDatesPresenter presenter;

    public SetDatesViewModel() {
        presenter = new SetDatesPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setOrganizer( (Organizer)(new MemoryLoggedInUser()).getUser() );
    }

    public SetDatesPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
