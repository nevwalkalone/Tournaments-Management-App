package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class ParticipatingTeamsPresenter {
    private ParticipatingTeamsView view;
    private TeamDAO teamDAO;
    private ArrayList<Team> results = new ArrayList<>();

    public ParticipatingTeamsPresenter(){}

    public void findParticipatingTeams(Tournament tournament){
        if (tournament!= null){
            results.clear();
            for (Participation participation : tournament.getParticipations()){
                results.add( participation.getTeam());
            }

        }
    }

    public ArrayList<Team> getResults() {
        return results;
    }

    public void onTeamSelected(Team team){
        // todo
    }

    public void setView(ParticipatingTeamsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }


}
