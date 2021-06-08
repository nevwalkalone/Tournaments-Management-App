package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class TournamentGroupsViewModel extends ViewModel {
    TournamentGroupsPresenter presenter;

    /**
     * the constructor
     */
    public TournamentGroupsViewModel(){
        presenter = new TournamentGroupsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    /** get the presenter
     * @return the TournamentGroupsPresenter instance
     */
    public TournamentGroupsPresenter getPresenter(){
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
