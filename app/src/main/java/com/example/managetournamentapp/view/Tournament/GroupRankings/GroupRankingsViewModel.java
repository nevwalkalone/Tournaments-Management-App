package com.example.managetournamentapp.view.Tournament.GroupRankings;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class GroupRankingsViewModel extends ViewModel {
    GroupRankingsPresenter presenter;

    /**
     * the constructor
     */
    public GroupRankingsViewModel() {
        presenter = new GroupRankingsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    /**
     * @return the presenter instance
     */
    public GroupRankingsPresenter getPresenter() {
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
