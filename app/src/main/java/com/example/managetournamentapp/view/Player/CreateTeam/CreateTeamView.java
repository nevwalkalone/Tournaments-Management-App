package com.example.managetournamentapp.view.Player.CreateTeam;

import com.example.managetournamentapp.domain.Team;

public interface CreateTeamView {

    void startSaveTeam(String userName);

    String getTeamName();

    String getTeamColors();

    int getSportType();

    void setTeamName(String name);

    void setTeamColors(String colors);

    void setSportType(int position);

    void lockSportType();
}
