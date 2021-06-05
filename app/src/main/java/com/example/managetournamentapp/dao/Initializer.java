package com.example.managetournamentapp.dao;


import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Round;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData() {
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

        playerDAO.save(new Player("tomtomtom", "jerry", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tom12", "12345")));
        playerDAO.save(new Player("tom2", "jerry", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tom23", "12345")));
        playerDAO.save(new Player("tom3", "jerry", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tom34", "12345")));
        playerDAO.save(new Player("nikolakis", "jerry", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("nikos12", "12345")));
        playerDAO.save(new Player("tasoulis", "jerry", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tasos13", "12345")));
        playerDAO.save(new Player("giorgakis", "jerry", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("giorgos14", "12345")));
        playerDAO.save(new Player("johny", "boy", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny14", "12345")));
        playerDAO.save(new Player("johny", "boy15", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny15", "12345")));
        playerDAO.save(new Player("johny", "boy16", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny16", "12345")));
        playerDAO.save(new Player("johny", "boy17", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny17", "12345")));
        playerDAO.save(new Player("johny", "boy18", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny18", "12345")));
        playerDAO.save(new Player("johny", "boy19", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny19", "12345")));
        playerDAO.save(new Player("johny", "boy20", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny20", "12345")));
        playerDAO.save(new Player("johny", "boy21", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny21", "12345")));
        playerDAO.save(new Player("johny", "boy22", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny22", "12345")));
        playerDAO.save(new Player("johny", "boy23", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny23", "12345")));
        playerDAO.save(new Player("johny", "boy24", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny24", "12345")));
        playerDAO.save(new Player("johny", "boy25", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny25", "12345")));
        playerDAO.save(new Player("johny", "boy26", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny26", "12345")));
        playerDAO.save(new Player("johny", "boy27", "Athens", "69000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("johny27", "12345")));










        playerDAO.find("tom12").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("tom23").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("tom34").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("nikos12").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("tasos13").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("giorgos14").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny14").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny15").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny16").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny17").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny18").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny19").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny20").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny21").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny22").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny23").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny24").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny25").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny26").addSportInterested(new Sport("Basketball3v3"));
        playerDAO.find("johny27").addSportInterested(new Sport("Basketball3v3"));

        ArrayList<LocalDate> dates = new ArrayList<>();
        for (int i = 1; i < 64; i++) {
            dates.add(LocalDate.now());
        }

        organizerDAO.save(new Organizer("Nikos", "Nikopoulos", "69xxxxxxxx", "nikosnik@gmail.com", LocalDate.parse("2000-01-01"), new Credentials("nikos", "12345"), "ESKA"));
        Tournament tour1 = new Tournament("TOURNOUA1", LocalDate.parse("2030-05-10"), LocalDate.parse("2030-05-29"), "ATHENS", (new Sport("Basketball3v3")),
                32, AgeDivision.K100, dates);
        tournamentDAO.save(tour1);
        organizerDAO.findByTitle("ESKA").addTournament(tour1);

        for (Round round : tour1.getRounds()){
            ArrayList<Team> emptyTeams = new ArrayList<>();
            for (int i=0;i<round.getTeamsNumber();i++)
                emptyTeams.add(new Team());
            round.setup(emptyTeams);
        }


        teamDAO.save(new Team("Celtic", (new Sport("Basketball3v3")), AgeDivision.K100, playerDAO.find("tom12"), "green"));
        teamDAO.find("Celtic").addPlayer(playerDAO.find("tom23"));
        teamDAO.find("Celtic").addPlayer(playerDAO.find("tom34"));
        teamDAO.save(new Team("Bulls", (new Sport("Basketball3v3")), AgeDivision.K100, playerDAO.find("nikos12"), "green"));
        teamDAO.find("Bulls").addPlayer(playerDAO.find("tasos13"));
        teamDAO.find("Bulls").addPlayer(playerDAO.find("giorgos14"));

        Participation part = new Participation(tour1, teamDAO.find("Celtic"));
        participationDAO.save(part);
//        teamDAO.find("Celtic").addParticipation(part);
        Participation part2 = new Participation(tour1, teamDAO.find("Bulls"));
        participationDAO.save(part2);
//        teamDAO.find("Bulls").addParticipation(part2);


        //TODO INVITES
        playerDAO.find("tom12").addInvite(new Invitation(teamDAO.find("Bulls")));

        //TODO CHECK ADD PARTICIPATION
        //adding participation to tournament
//        Tournament temp = tournamentDAO.find(tour1.getTitle());
//        temp.friendGetParticipations().add(part);
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
