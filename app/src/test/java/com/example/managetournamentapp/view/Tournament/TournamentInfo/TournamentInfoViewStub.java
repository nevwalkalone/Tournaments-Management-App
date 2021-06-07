package com.example.managetournamentapp.view.Tournament.TournamentInfo;

public class TournamentInfoViewStub implements TournamentInfoView {
    String teamsnumber, location, startdate, finishdate, sportType, title, ageDivision, description;

    @Override
    public void setTeamsNumber(String teamsNumber) {
        this.teamsnumber = teamsNumber;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setStartDate(String startDate) {
        this.startdate = startDate;
    }

    @Override
    public void setFinishDate(String finishDate) {
        this.finishdate = finishDate;
    }

    @Override
    public void setsportType(String sportType) {
        this.sportType = sportType;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setAgeDivision(String ageDivision) {
        this.ageDivision = ageDivision;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void startEditTournament() {

    }

    @Override
    public void changesOfAccess() {

    }

    @Override
    public void deleteConfirmation() {

    }

    @Override
    public void noDeleteTournament() {

    }

    @Override
    public void yesDeleteTournament(String title) {

    }

    @Override
    public void showToast(String txt) {

    }
}