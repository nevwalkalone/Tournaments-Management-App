package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import androidx.lifecycle.ViewModel;

import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class TournamentGroupsViewModel extends ViewModel {
    TournamentGroupsPresenter presenter;

    public TournamentGroupsViewModel(){
        presenter = new TournamentGroupsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    public TournamentGroupsPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
