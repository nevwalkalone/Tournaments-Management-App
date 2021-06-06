package com.example.managetournamentapp.view.Organizer.CreateTournament;


import androidx.lifecycle.ViewModel;


import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

public class CreateTournamentViewModel extends ViewModel {
    CreateTournamentPresenter presenter;

    public CreateTournamentViewModel() {
        presenter = new CreateTournamentPresenter();
        presenter.setTournamentDAO( new TournamentDAOMemory());
        presenter.setOrganizer(new MemoryLoggedInUser().getUser());

    }

    public CreateTournamentPresenter getPresenter() {

        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
