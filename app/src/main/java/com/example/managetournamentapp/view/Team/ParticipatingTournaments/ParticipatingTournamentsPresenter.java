package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

import android.util.Log;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import java.util.ArrayList;

public class ParticipatingTournamentsPresenter {
    private ParticipatingTournamentsView view;
    private TournamentDAO tournamentDAO;
    private TeamDAO teamDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public ParticipatingTournamentsPresenter(){}

    public void findParticipatingTournaments(String teamName){
        Team team = teamDAO.find(teamName);

        if (team==null)
            return;

        results.clear();
        for (Participation p : team.getParticipations())
            results.add( p.getTournament()  );
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void setView(ParticipatingTournamentsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }


    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void onAddParticipation(){
        view.startAddParticipation();
    }

}
