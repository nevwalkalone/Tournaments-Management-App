package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

public class TournamentGroupsPresenter {
    private TournamentGroupsView view;
    private Tournament tournament;
    private TournamentDAO tournamentDAO;


    public TournamentGroupsPresenter(){    }

    public void findTournamentInfo(String tournamentName){
        if(tournamentName ==null){
            return;
        }
        tournament = tournamentDAO.find(tournamentName);
        if( tournament == null )
            return;
    }

    public void onGroup(int index){
        view.showPopup(index);
    }

    public void onGames(int index){
        view.showGroupGames( tournament.getTitle(),tournament.getRounds().get(0).getTeamsNumber(), index  );
    }

    public void onRankings(int index){
        view.showGroupRankings( tournament.getTitle(),tournament.getRounds().get(0).getTeamsNumber(), index  );
    }

    public void findAccess(){
        view.changesOfAccess(tournament.getRounds().get(0).getGroups().size() );
    }


    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(TournamentGroupsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
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
