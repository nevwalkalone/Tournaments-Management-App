package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

public class OrganizerInfoViewModel extends ViewModel {
    OrganizerInfoPresenter presenter;

    public OrganizerInfoViewModel(){
        presenter = new OrganizerInfoPresenter();
        presenter.setOrganizer(MemoryLoggedInUser.getUser());
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
