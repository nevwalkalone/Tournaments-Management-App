package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.util.ArrayList;

public class ParticipatingTeamsPresenter {
    private ParticipatingTeamsView view;
    private TeamDAO teamDAO;
    private TournamentDAO tournamentDAO;
    private ArrayList<Team> results = new ArrayList<>();
    private Tournament tournament;

    public ParticipatingTeamsPresenter() {
    }

    public void findParticipatingTeams(String tournamentName) {
        tournament = tournamentDAO.find(tournamentName);
        if (tournament == null) {
            return;
        }
        results.clear();
        for (Participation participation : tournament.getParticipations()) {
            results.add(participation.getTeam());

        }
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public ArrayList<Team> getResults() {
        return results;
    }

    public void onTeamSelected(Team team) {
        view.startTeamPage(team.getName());
    }

    public void setView(ParticipatingTeamsView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void onHomePage(){
        User user = new MemoryLoggedInUser().getUser();
        if (user instanceof Player){
            view.backToHomePage(true,user.getCredentials().getUsername());
        }
        else{
            view.backToHomePage(false,((Organizer)user).getTitle());
        }
    }


}
