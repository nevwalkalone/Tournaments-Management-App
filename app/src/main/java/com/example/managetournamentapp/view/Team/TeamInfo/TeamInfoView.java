package com.example.managetournamentapp.view.Team.TeamInfo;

public interface TeamInfoView {

    void setTeamName(String name);

    void setColors(String colors);

    void setAgeDivision(String division);

    void setSport(String sport);

    void startEditTeam();

    void showToast(String txt);

    void startDeleteTeam(String playerUsername);

    void changesOfAccess();

}
