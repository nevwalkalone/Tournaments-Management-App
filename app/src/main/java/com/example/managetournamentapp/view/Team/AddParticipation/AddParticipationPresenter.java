package com.example.managetournamentapp.view.Team.AddParticipation;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import java.util.ArrayList;

public class AddParticipationPresenter {
    private AddParticipationView view;
    private TournamentDAO tournamentDAO;
    private TeamDAO teamDAO;
    private ArrayList<Tournament> results = new ArrayList<>();
    private Team team;

    public AddParticipationPresenter(){}

    public void findTournaments(String teamName){
        team = teamDAO.find(teamName);

        if (team==null)
            return;

        results.clear();
        for (Tournament tournament : tournamentDAO.findAll()){
            Participation part = new Participation(tournament, team);
            if ( team.canParticipate(part)  )
                results.add(tournament);
        }
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void setView(AddParticipationView view) {
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

    public void onAddParticipation(String tournamentName){
        Tournament tournament = tournamentDAO.find(tournamentName);
        Participation part = new Participation(tournament, team);
        team.addParticipation(part);

    }
    public void onTournamentPage(String tournamentName){
        Tournament tournament = tournamentDAO.find(tournamentName);
        view.startTournamentPage(tournament);
    }

    public void onStartPartTournaments(){
        String teamName = team.getName();
        view.startPlayerPage(team.getCaptain().getCredentials().getUsername());

    }

}
