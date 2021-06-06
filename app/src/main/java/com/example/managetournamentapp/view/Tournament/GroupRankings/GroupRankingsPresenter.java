package com.example.managetournamentapp.view.Tournament.GroupRankings;


import android.util.Log;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Group;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class GroupRankingsPresenter {
    private GroupRankingsView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Team> results = new ArrayList<>();
    private Tournament tournament;

    public void findTeams(String tournamentName, int specificGroup){
        if (tournamentName == null)
            return;
        tournament = tournamentDAO.find(tournamentName);
        if (tournament== null){
            return;
        }
        results.clear();

        Group group = tournament.getRounds().get(0).getGroups().get(specificGroup);
        group.refreshRankings();
        Log.wtf("rankk", group.getRankings().toString());
        results.addAll( group.getRankings().keySet());
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public ArrayList<Team> getResults() {
        return results;
    }

    public void setView(GroupRankingsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }


}
