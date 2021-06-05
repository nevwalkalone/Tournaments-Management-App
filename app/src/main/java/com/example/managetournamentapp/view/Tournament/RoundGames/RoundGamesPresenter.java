package com.example.managetournamentapp.view.Tournament.RoundGames;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Group;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Round;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;

import java.util.ArrayList;


public class RoundGamesPresenter {
    public RoundGamesView view;
    private TournamentDAO tournamentDAO;
    private Tournament tournament;
    private LoggedInUser loggedInUser;
    private ArrayList<Game> results = new ArrayList<>();
    private boolean hasAccess;

    public RoundGamesPresenter(){}

    public void findGames(String tournamentTitle, int roundTeamsNumber, int specificGroup){
        if (tournamentTitle==null)
            return;
        tournament = tournamentDAO.find(tournamentTitle);
        if (tournament == null)
            return;

        findAccess();
        results.clear();
        for (Round round : tournament.getRounds()){
            if (round.getTeamsNumber()==roundTeamsNumber){
                ArrayList<Group> groupsWanted = new ArrayList<>();
                if (specificGroup==-1)
                    groupsWanted.addAll( round.getGroups());
                else
                    groupsWanted.add(round.getGroups().get(specificGroup)) ;

                for(Group group : groupsWanted){
                    results.addAll(group.getGames());
                }
                return;
            }
        }
    }


    public void onPressed(Game game){
        //todo erase comments
        game.setTeamA(new TeamDAOMemory().find("Bulls"));
        game.setTeamB(new TeamDAOMemory().find("Bulls"));
        if ( hasAccess)
            if (game.isFinished())
                view.showToast("THE SCORE HAS ALREADY BEEN SET");
            else if (game.getTeamA().getName()==null || game.getTeamA().getName()==null)
                view.showToast("THE TEAMS HAVE NOT BEEN SET");
            else
                view.showPopup(game);
    }

    public void onSave(Game game, String scoreA, String scoreB){
        if (scoreA==null || scoreA.isEmpty() || scoreB==null || scoreB.isEmpty() )
            return;

        game.setScoreA( Integer.parseInt(scoreA) );
        game.setScoreB( Integer.parseInt(scoreB) );
        game.setFinished(true);
        view.recreateView();
    }

    public void findAccess(){
        hasAccess =false;
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof Organizer)
                if ( ((Organizer)loggedInUser.getUser()).getTournaments().contains(tournament) )
                    hasAccess = true;
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
