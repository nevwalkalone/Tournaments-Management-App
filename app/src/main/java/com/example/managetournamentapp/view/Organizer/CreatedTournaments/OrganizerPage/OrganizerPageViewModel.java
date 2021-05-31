package com.example.managetournamentapp.view.Organizer.CreatedTournaments.OrganizerPage;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.OrganizerPage.OrganizerPagePresenter;



public class OrganizerPageViewModel extends ViewModel {
    OrganizerPagePresenter presenter;

    public OrganizerPageViewModel() {
        super();
        presenter = new OrganizerPagePresenter();
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
