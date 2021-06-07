package com.example.managetournamentapp.view.Team.TeamPage;


import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.User;


public class TeamPagePresenter {
    private TeamPageView view;
    private Team team;
    private TeamDAO teamDAO;
    private LoggedInUser loggedInUser;


    public TeamPagePresenter(){}

    public void findTeamInfo(String teamName){
        if (teamName==null)
            return;
        team = teamDAO.find(teamName);
        if( team == null )
            return;
    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof Player)
                if ( team.getPlayers().contains((Player)loggedInUser.getUser())  )
                    return;
        view.changesOfAccess();
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setView(TeamPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void onHomePage(){
        User user = loggedInUser.getUser();
        if (loggedInUser.getUser() instanceof Player){
          view.backToHomePage(true,user.getCredentials().getUsername());
        }
        else{
            view.backToHomePage(false,((Organizer)user).getTitle());
        }
    }
}
