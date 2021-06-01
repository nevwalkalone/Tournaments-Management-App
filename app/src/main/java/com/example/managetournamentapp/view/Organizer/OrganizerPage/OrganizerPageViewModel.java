package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import androidx.lifecycle.ViewModel;




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
