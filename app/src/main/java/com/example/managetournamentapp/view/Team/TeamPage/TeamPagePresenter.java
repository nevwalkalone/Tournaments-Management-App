package com.example.managetournamentapp.view.Team.TeamPage;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;


public class TeamPagePresenter {
    private TeamPageView view;
    private Team team;
    private TeamDAO teamDAO;


    public TeamPagePresenter(){}

    public void findTeamInfo(String teamName){
        if (teamName==null)
            return;
        team = teamDAO.find(teamName);
        if( team == null )
            return;

    }

    public void findAccess(){
        if (MemoryLoggedInUser.getUser() != null )
            if (MemoryLoggedInUser.getUser() instanceof Player)
                if ( team.getPlayers().contains(MemoryLoggedInUser.getUser())  )
                    return;
        view.changesOfAccess();
    }

    public void onTeamInfo(){
        view.startTeamInfo();
    }

    public void onTeamPlayers(){
        view.startTeamPlayers();
    }

    public void onTeamParticipations(){
        view.startTeamParticipations();
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void setView(TeamPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
