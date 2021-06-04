package com.example.managetournamentapp.view.Tournament.TournamentInfo;

public interface TournamentInfoView {

    void setTeamsNumber(String teamsNumber);

    void setLocation(String location);

    void setStartDate(String startDate);

    void setFinishDate(String finishDate);

    void setsportType(String sportType);

    void setTitle(String title);

    void setAgeDivision(String ageDivision);

    void setDescription(String description);

    void startEditTournament();


    void changesOfAccess();

    void deleteConfirmation();

    void noDeleteTournament();

    void yesDeleteTournament();

    void showCantDelete();

}
