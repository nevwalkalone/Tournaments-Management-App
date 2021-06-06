package com.example.managetournamentapp.view.Team.InvitePlayers;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;

import java.util.ArrayList;

public class InvitePlayersPresenter {
    private InvitePlayersView view;
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;
    private String teamName;
    private ArrayList<Player> results = new ArrayList<>();
    private LoggedInUser loggedInUser;


    public InvitePlayersPresenter() {
    }

    public void findPlayers(String teamName) {
        this.teamName = teamName;
        results.clear();
        ArrayList<Player> allPlayers = playerDAO.findAll();
        Team team = teamDAO.find(teamName);
        for (Player player : allPlayers) {
            boolean alreadyInvitedForTheTeam = player.getInvitesReceived().contains(new Invitation(team));
            if (player.canJoin(team) && !alreadyInvitedForTheTeam)
                results.add(player);
        }

    }

    public ArrayList<Player> getResults() {
        return results;
    }

    public void onPlayerAccountSelected(Player p) {
        view.startPlayerPage(p);
    }

    public void inviteNewPlayer(String teamName, Player p) {
        Team team = teamDAO.find(teamName);
        playerDAO.find(p.getCredentials().getUsername()).addInvite(new Invitation(team));
    }

    public void setView(InvitePlayersView view) {
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

    public void displayPopAction(int layout, String msg, int btn1, int btn2, boolean invited) {
        view.displayPopUpAction(layout, msg, btn1, btn2, invited);
    }


    public void closePopAction() {
        view.dismissPopUpAction();
    }

    public void restartActivity() {
        view.restartActivity();
    }
}
