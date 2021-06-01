package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.domain.Organizer;

public class OrganizerInfoViewModel extends ViewModel {
    OrganizerInfoPresenter presenter;

    public OrganizerInfoViewModel(){
        super();
        presenter = new OrganizerInfoPresenter();
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
