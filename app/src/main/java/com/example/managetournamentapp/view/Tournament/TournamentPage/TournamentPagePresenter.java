package com.example.managetournamentapp.view.Tournament.TournamentPage;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

public class TournamentPagePresenter {
    private TournamentPageView view;
    private LoggedInUser loggedInUser;

    /**
     * the default constructor
     */
    public TournamentPagePresenter(){ }

    /**
     * direct the logged in user to the tournament info activity starts
     */
    public void onTournamentInfo(){
        view.startTournamentInfo();
    }

    /**
     * direct the logged in user to the participating teams activity
     */
    public void onTournamentTeams(){
        view.startTeamsParticipating();
    }

    /**
     * direct the logged in user to the tournament rounds activity
     */
    public void onTournamentGames(){
        view.startTournamentGames();
    }

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(TournamentPageView view) {
        this.view = view;
    }

    /**
     * clear the view
     */
    public void clearView(){
        this.view = null;
    }

    /**
     * direct the logged in user to their home page
     */
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
