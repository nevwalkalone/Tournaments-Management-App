package com.example.managetournamentapp.view.User.RegisterOrganizer;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;

/**
 * Developed for the purposes of University Lesson "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public class RegisterOrganizerViewModel extends ViewModel {

    RegisterOrganizerPresenter presenter;

    /**
     * the default constructor
     */
    public RegisterOrganizerViewModel() {
        presenter = new RegisterOrganizerPresenter();
        presenter.setLoggedInUser( new MemoryLoggedInUser());
        presenter.setOrganizerDAO( new OrganizerDAOMemory());
    }

    /**
     * @return the presenter instance
     */
    public RegisterOrganizerPresenter getPresenter() {
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