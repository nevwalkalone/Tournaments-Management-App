package com.example.managetournamentapp.dao;

import android.util.Log;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData(){
        eraseData();
        GameDAO gameDAO = getGameDAO();
        GroupDAO groupDAO = getGroupDAO();
        InvitationDAO invitationDAO = getInvitationDAO();
        OrganizerDAO organizerDAO = getOrganizerDAO();
        ParticipationDAO participationDAO = getParticipationDAO();
        PlayerDAO playerDAO = getPlayerDAO();
        RoundDAO roundDAO = getRoundDAO();
        TeamDAO teamDAO = getTeamDAO();
        TournamentDAO tournamentDAO = getTournamentDAO();

        playerDAO.save( new Player("tom", "jerry","Athens",  "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tom", "123")));
        playerDAO.save( new Player("tom2", "jerry","Athens",  "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tom2", "123")));
        playerDAO.save( new Player("tom3", "jerry","Athens",  "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tom3", "123")));
        playerDAO.find("tom").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("tom2").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("tom3").addSportInterested(new Sport("Basketball3v3"));

        ArrayList<LocalDate> dates = new ArrayList<>();
        for (int i = 1; i < 64; i++) {
            dates.add(LocalDate.now());
        }

        organizerDAO.save( new Organizer("Nikos", "Nikopoulos", "69xxxxxxxx", "nikosnik@gmail.com",  LocalDate.parse("2000-01-01"), new Credentials("nikos", "123"), "ESKA"));
        Tournament tour1 =  new Tournament("TOURNOUA1", LocalDate.parse("2030-05-10"), LocalDate.parse("2030-05-29"), "ATHENS", (new Sport("Basketball3v3")),
                32, AgeDivision.K100, dates);
        tournamentDAO.save(tour1);
        organizerDAO.find("ESKA").addTournament(tour1);

        teamDAO.save(  new Team("Celtic", (new Sport("Basketball3v3")), AgeDivision.K100, playerDAO.find("tom") , "green") );
        teamDAO.find( "Celtic" ).addPlayer( playerDAO.find("tom2")  );
        teamDAO.find( "Celtic" ).addPlayer( playerDAO.find("tom3") );

        Participation part = new Participation( tour1, teamDAO.find("Celtic") );
        participationDAO.save( part);
        teamDAO.find( "Celtic" ).addParticipation(part);

    }

    public abstract GameDAO getGameDAO();

    public abstract GroupDAO getGroupDAO();

    public abstract InvitationDAO getInvitationDAO();

    public abstract OrganizerDAO getOrganizerDAO();

    public abstract ParticipationDAO getParticipationDAO();

    public abstract PlayerDAO getPlayerDAO();

    public abstract RoundDAO getRoundDAO();

    public abstract TeamDAO getTeamDAO();

    public abstract TournamentDAO getTournamentDAO();



}
