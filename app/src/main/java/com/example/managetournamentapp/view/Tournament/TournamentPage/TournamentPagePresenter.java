package com.example.managetournamentapp.view.Tournament.TournamentPage;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

public class TournamentPagePresenter {
    private TournamentPageView view;
    private Tournament tournament;
    private LoggedInUser loggedInUser;

    public TournamentPagePresenter(){

    }

    public void onTournamentInfo(){
        view.startTournamentInfo();
    }

    public void onTournamentTeams(){
        view.startTeamsParticipating();
    }

    public void onTournamentGames(){
        view.startTournamentGames();
    }

    public void setView(TournamentPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void onHomePage(){
        loggedInUser = new MemoryLoggedInUser();
        User user = loggedInUser.getUser();
        if (loggedInUser.getUser() instanceof Player){
            view.backToHomePage(true,user.getCredentials().getUsername());
        }
        else{
            view.backToHomePage(false,((Organizer)user).getTitle());
        }
    }
}
