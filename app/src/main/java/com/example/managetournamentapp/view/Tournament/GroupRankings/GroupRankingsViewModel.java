package com.example.managetournamentapp.view.Tournament.GroupRankings;

import androidx.lifecycle.ViewModel;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class GroupRankingsViewModel extends ViewModel {
    GroupRankingsPresenter presenter;

    public GroupRankingsViewModel() {
        presenter = new GroupRankingsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
    }

    public GroupRankingsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
