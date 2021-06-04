package com.example.managetournamentapp.view.Tournament.RoundGames;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Group;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Round;
import com.example.managetournamentapp.domain.Tournament;
import java.util.ArrayList;


public class RoundGamesPresenter {
    public RoundGamesView view;
    private TournamentDAO tournamentDAO;
    private Tournament tournament;
    private LoggedInUser loggedInUser;
    private ArrayList<Game> results = new ArrayList<>();

    public RoundGamesPresenter(){}

    public void findGames(String tournamentTitle, int roundTeamsNumber){
        if (tournamentTitle==null)
            return;
        tournament = tournamentDAO.find(tournamentTitle);
        if (tournament == null)
            return;

        results.clear();
        for (Round round : tournament.getRounds()){
            if (round.getTeamsNumber()==roundTeamsNumber){
                for(Group group : round.getGroups()){
                    results.addAll(group.getGames());
                }
                return;
            }
        }
    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof Organizer)
                if ( ((Organizer)loggedInUser.getUser()).getTournaments().contains(tournament) )
                    return;
        view.changesOfAccess();
    }

    public ArrayList<Game> getResults() {
        return results;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(RoundGamesView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
