package com.example.managetournamentapp.view.Player.CreateTeam;

import com.example.managetournamentapp.domain.Team;

public interface CreateTeamView {

    void startSaveTeam();

    String getTeamName();

    String getTeamColors();

    int getSportType();

    String getConnectedTeamName();

    void setTeamName(String name);

    void setTeamColors(String colors);

    void setSportType(int position);

    void lockSportType();
}
