package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

import com.example.managetournamentapp.dao.LoggedInUser;
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


public class ParticipatingTournamentsPresenter {
    private ParticipatingTournamentsView view;
    private TournamentDAO tournamentDAO;
    private TeamDAO teamDAO;
    private ArrayList<Tournament> results = new ArrayList<>();
    private Team team;
    private LoggedInUser loggedInUser;

    public ParticipatingTournamentsPresenter(){}

    public void findParticipatingTournaments(String teamName){
        if (teamName==null)
            return;
        team = teamDAO.find(teamName);
        if (team==null)
            return;
        results.clear();
        for (Participation p : team.getParticipations())
            results.add( p.getTournament()  );
    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof Player)
                if ( ((Player)loggedInUser.getUser()).equals( team.getCaptain()) )
                    return;
        view.changesOfAccess();
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

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
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

    public void onHomePage(){
        User user = loggedInUser.getUser();
        view.backToHomePage(user.getCredentials().getUsername());

    }

}
