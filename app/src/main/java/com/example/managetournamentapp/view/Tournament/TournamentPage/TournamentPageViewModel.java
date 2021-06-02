package com.example.managetournamentapp.view.Tournament.TournamentPage;

import androidx.lifecycle.ViewModel;

public class TournamentPageViewModel extends ViewModel {
    TournamentPagePresenter presenter;

    public TournamentPageViewModel(){
        super();
        presenter = new TournamentPagePresenter();
    }

    public TournamentPagePresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // avoid leaking activity for any reasons
        presenter.clearView();
    }
}
