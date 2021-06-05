package com.example.managetournamentapp.view.Organizer.CreateTournament;


import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamView;

import java.time.LocalDate;
import java.util.ArrayList;

public interface CreateTournamentView {

    void startSaveTournament(String tournamentTitle);

    void startSetDates(ArrayList<String> basicInfo);

    String getTournamentTitle();

    String getLocation();

    String getStartDate();

    String getFinishDate();

    int getAgeDivision();

    String getTeamsNumber();

    int getSportType();

    void setTournamentTitle(String title);

    void setLocation(String location);

    void setStartDate(String date);

    void setFinishDate(String date);

    void setAgeDivision(int position);

    void setTeamsNumber(String teamsNumber);

    void setSportType(int position);

    void lockSportType();

    void showPopUp(CreateTournamentView view, String msg);

}
