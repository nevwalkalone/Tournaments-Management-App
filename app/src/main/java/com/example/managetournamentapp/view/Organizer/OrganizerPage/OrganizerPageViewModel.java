package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;


public class OrganizerPageViewModel extends ViewModel {
    OrganizerPagePresenter presenter;

    public OrganizerPageViewModel() {
        presenter = new OrganizerPagePresenter();
        presenter.setOrganizer(new MemoryLoggedInUser().getUser());
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
