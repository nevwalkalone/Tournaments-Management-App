package com.example.managetournamentapp.view.Player.ReceivedInvites;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;

import java.util.ArrayList;

public class ReceivedInvitesPresenter {
    private ReceivedInvitesView view;
    private LoggedInUser loggedInUser;
    private Player player;
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;
    private ArrayList<Invitation> invites = new ArrayList<>();
    private ArrayList<Team> teamsInvites = new ArrayList<>();


    public ReceivedInvitesPresenter() {

    }

    public void findInvites(String playerUsername) {
        if (playerUsername == null)
            return;
        player = playerDAO.find(playerUsername);
        invites.clear();
        teamsInvites.clear();
        ArrayList<Invitation> allInvites = player.getInvitesReceived();
        for (Invitation invitation : allInvites) {
            System.out.println("Invitation: " + invitation.getPending());
            if (invitation.getPending())        // GET ONLY PENDING INVITES OF PLAYER
                invites.add(invitation);
        }
        for (Invitation invitation : invites)
            teamsInvites.add(invitation.getTeam());
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


    public String getPlayerName() {
        if (player == null)
            return "";

        return player.getName();
    }


    public void setView(ReceivedInvitesView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public ArrayList<Invitation> getInvites() {
        return invites;
    }

    public ArrayList<Team> getTeamsInvites() {
        return teamsInvites;
    }

    public void declineInvitation(Invitation invitation) {
        player.replyToInvitation(invitation, false);
        player.removeInvite(invitation);
    }

    public void acceptInvitation(Invitation invitation) {
        player.replyToInvitation(invitation, true);
        player.removeInvite(invitation);
    }

    public void onTeamPageClick() {
        view.startTeamPage();
    }
}
