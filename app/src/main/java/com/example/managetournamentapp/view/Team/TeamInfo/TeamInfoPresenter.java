package com.example.managetournamentapp.view.Team.TeamInfo;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;

public class TeamInfoPresenter {
    private TeamInfoView view;
    private Team team;
    private TeamDAO teamDAO;
    private LoggedInUser loggedInUser;

    public TeamInfoPresenter(){}

    public void findTeamInfo(String teamName) {
        if (teamName==null)
            return;
        team = teamDAO.find(teamName);
        if( team == null )
            return;

        //todo there is an error here

        view.setTeamName(team.getName());
        view.setColors(team.getColors() );
        view.setSport(team.getSportType().getName());
        view.setAgeDivision(team.getAgeDivision().toString());
    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof  Player)
                if ( ((Player)loggedInUser.getUser()).equals( team.getCaptain()) )
                    return;
        view.changesOfAccess();
    }

    public void onEditTeam(){
        view.startEditTeam();
    }

    public void onDeleteTeam(){
        //todo more
        view.startDeleteTeam(((Player)loggedInUser.getUser()).getCredentials().getUsername() );
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setView(TeamInfoView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
