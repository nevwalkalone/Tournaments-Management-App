package com.example.managetournamentapp.view.Team.JoinedPlayers;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.util.ArrayList;

public class JoinedPlayersPresenter {

    private JoinedPlayersView view;
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;
    private String teamName;
    private ArrayList<Player> results = new ArrayList<>();
    private LoggedInUser loggedInUser;

    public JoinedPlayersPresenter() {
    }

    public void findPlayers(String teamName) {
        this.teamName = teamName;
        results.clear();
        results = teamDAO.find(teamName).getPlayers();
    }

    public void removePlayer(String teamName, Player player) {
        results.clear();
        teamDAO.find(teamName).removePlayer(player);
        results = teamDAO.find(teamName).getPlayers();
    }

    public void findAccess() {
        Team team = teamDAO.find(teamName);
        boolean captain = false;
        boolean player = false;
        if (loggedInUser.getUser() != null) {
            if (loggedInUser.getUser() instanceof Player) {
                player = true;
                if ((loggedInUser.getUser() ).equals(team.getCaptain())) {
                    captain = true;
                }

            }
        }
        view.changesOfAccess(captain,player);
    }


    public ArrayList<Player> getResults() {
        return results;
    }

    public void onPlayerSelected(Player p) {
        // todo
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
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
