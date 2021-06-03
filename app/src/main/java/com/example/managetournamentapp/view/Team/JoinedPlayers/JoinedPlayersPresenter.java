package com.example.managetournamentapp.view.Team.JoinedPlayers;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Player;

import java.util.ArrayList;

public class JoinedPlayersPresenter {

    private JoinedPlayersView view;
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;
    private ArrayList<Player> results = new ArrayList<>();

    public JoinedPlayersPresenter() {
    }

    public void findPlayers(String teamName) {
        results.clear();
        results = teamDAO.find(teamName).getPlayers();
    }

    public void removePlayer(String teamName, Player player) {
        results.clear();
        teamDAO.find(teamName).removePlayer(player);
        results = teamDAO.find(teamName).getPlayers();
    }

    public ArrayList<Player> getResults() {
        return results;
    }

    public void onPlayerSelected(Player p) {
        // todo
    }


    public void setView(JoinedPlayersView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }
}
