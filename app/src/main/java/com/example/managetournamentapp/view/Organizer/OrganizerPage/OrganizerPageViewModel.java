package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import androidx.lifecycle.ViewModel;


import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;


public class OrganizerPageViewModel extends ViewModel {
    OrganizerPagePresenter presenter;

    public OrganizerPageViewModel() {
        presenter = new OrganizerPagePresenter();
        presenter.setLoggedInUser(new MemoryLoggedInUser());
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
    }

    public OrganizerPagePresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reason
        presenter.clearView();
    }
}
