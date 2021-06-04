package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;

public class OrganizerInfoViewModel extends ViewModel {
    OrganizerInfoPresenter presenter;

    public OrganizerInfoViewModel(){
        presenter = new OrganizerInfoPresenter();
        presenter.setOrganizer((Organizer)new MemoryLoggedInUser().getUser());
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
    }

    public OrganizerInfoPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reason
        presenter.clearView();
    }

}
