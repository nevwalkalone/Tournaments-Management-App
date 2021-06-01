package com.example.managetournamentapp.view.Team.TeamPage;

import com.example.managetournamentapp.domain.Team;

public class TeamPagePresenter {
    private TeamPageView view;
    private Team team;


    public TeamPagePresenter(){}

    public void findTeamInfo(Team team){
        this.team = team;

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

    public void setView(TeamPageView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
