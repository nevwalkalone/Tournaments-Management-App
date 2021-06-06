package com.example.managetournamentapp.view.Tournament.GroupRankings;

import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;

import java.util.ArrayList;

public class GroupRankingsViewStub implements GroupRankingsView {
    ArrayList<Team> teams = new TournamentDAOMemory().find("TOURNOUA1").findTeams();

    @Override
    public ArrayList<Team> getTeamsList() {
        return teams;
    }
}
