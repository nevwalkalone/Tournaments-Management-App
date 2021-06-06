package com.example.managetournamentapp.view.Team.TeamInfo;

public class TeamInfoViewStub implements TeamInfoView{
    String name="Celtic9",colors="green",division="K100",sport="Basketball3v3";

    @Override
    public void setTeamName(String name) {
        this.name = name;
    }

    @Override
    public void setColors(String colors) {
        this.colors = colors;
    }

    @Override
    public void setAgeDivision(String division) {
        this.division = division;
    }

    @Override
    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public void startEditTeam() {

    }

    @Override
    public void showToast(String txt) {

    }

    @Override
    public void startDeleteTeam(String playerUsername) {

    }

    @Override
    public void changesOfAccess() {

    }
}
