package com.example.managetournamentapp.view.Team.InvitePlayers;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;
import java.util.ArrayList;

public class InvitePlayersPresenter {
    private InvitePlayersView view;
    private PlayerDAO playerDAO;
    private ArrayList<Player> results = new ArrayList<>();

    public InvitePlayersPresenter(){}

    public void findPlayers(){
        results.clear();
        results = playerDAO.findAll();
    }

    public ArrayList<Player> getResults() {
        return results;
    }

    public void onPlayerSelected(Player p){
        // todo
    }

    public void setView(InvitePlayersView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }
}
