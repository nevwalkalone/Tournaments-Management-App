package com.example.managetournamentapp.view.Player.JoinedTeams;

import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import java.util.ArrayList;

public class JoinedTeamsPresenter {
    private JoinedTeamsView view;
    private TeamDAO teamDAO;
    private ArrayList<Team> results = new ArrayList<>();

    public JoinedTeamsPresenter(){}

    public void findJoinedTeams(User user){
        if (user == null)
            return;
        if ( !(user instanceof Player) )
            return;

        Player player = (Player) user;
        results.clear();
        results.addAll(player.getTeamsJoined());
    }

    public ArrayList<Team> getResults() {
        return results;
    }

    public void onAddTeam(){
        view.startAddTeam();
    }

    public void setView(JoinedTeamsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }


}
