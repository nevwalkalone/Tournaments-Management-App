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
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Helper Class that is responsible for initialing data in our database.
 * Βοηθητική κλάση που παρέχει δεδομένα για τα παραδείγματα και τις δοκιμασίες ελέγχου<p>
 * Βιβλία
 */

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
        ArrayList<Player> players = new ArrayList<>();
        new MemoryLoggedInUser().clear();

        //create 30 players
        for ( int i=0;i<35;i++ ){
            Player current = new Player("tomtom", "jerry", "Athens", "6900000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("tommy"+i, "12345"));
            current.addSportInterested(new Sport("Basketball3v3"));
            players.add(current);
            playerDAO.save(current);
        }
        Player testPlayer = new Player("gioza", "zagio", "Athens", "6900000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("gioza", "12345"));
        testPlayer.addSportInterested(new Sport("Basketball3v3"));
        players.add(testPlayer);
        playerDAO.save(testPlayer);

        //create 9 teams
        int j = 0;
        for ( int i=0;i<25;i+=3 ){
            Team current = new Team("Celtic"+j, (new Sport("Basketball3v3")), AgeDivision.K100, players.get(i), "green");
            current.addPlayer(players.get(i+1));
            current.addPlayer(players.get(i+2));
            teamDAO.save(current);
            j++;
        }
        Team testTeam = new Team("Celtic" + 10, (new Sport("Basketball3v3")), AgeDivision.K100, players.get(0), "green");
        testTeam.addPlayer(players.get(1));
        testTeam.addPlayer(players.get(2));
        teamDAO.save(testTeam);

        ArrayList<LocalDate> dates = new ArrayList<>();
        for (int i = 1; i < 64; i++) {
            dates.add(LocalDate.now());
        }
        organizerDAO.save(new Organizer("Takis", "Takis", "6900000000", "takistak@gmail.com", LocalDate.parse("2000-01-01"), new Credentials("takis", "12345"), "ESKANA"));
        organizerDAO.save(new Organizer("Nikos", "Nikopoulos", "6900000000", "nikosnik@gmail.com", LocalDate.parse("2000-01-01"), new Credentials("nikos", "12345"), "ESKA"));
        Tournament tour1 = new Tournament("TOURNOUA1", LocalDate.parse("2030-05-10"), LocalDate.parse("2030-05-29"), "ATHENS", (new Sport("Basketball3v3")), 8, AgeDivision.K100, dates);
        tournamentDAO.save(tour1);
        organizerDAO.findByTitle("ESKA").addTournament(tour1);
        for (Round round : tour1.getRounds()){
            ArrayList<Team> emptyTeams = new ArrayList<>();
            for (int i=0;i<round.getTeamsNumber();i++)
                emptyTeams.add(new Team());
            round.setup(emptyTeams);
        }

        Tournament tour2 = new Tournament("NBAGR", LocalDate.parse("2050-05-10"), LocalDate.parse("2050-05-29"), "ATHENS", (new Sport("Basketball3v3")), 8, AgeDivision.K100, dates);
        tournamentDAO.save(tour2);
        organizerDAO.findByTitle("ESKA").addTournament(tour2);
        for (Round round : tour2.getRounds()){
            ArrayList<Team> emptyTeams = new ArrayList<>();
            for (int i=0;i<round.getTeamsNumber();i++)
                emptyTeams.add(new Team());
            round.setup(emptyTeams);
        }

        Tournament testTournament = new Tournament("NBA", LocalDate.parse("2050-05-10"), LocalDate.parse("2050-05-29"), "ATHENS", (new Sport("Basketball3v3")), 8, AgeDivision.K100, dates);
        tournamentDAO.save(testTournament);

        //add teams to tournament
        for ( int i=0;i<8;i++ ){
            Team current = teamDAO.find("Celtic"+i);
            Participation part = new Participation(tour1, current);
            current.addParticipation(part);
        }

        //Invite initialize
        Invitation invitation = new Invitation(testTeam);
        playerDAO.find("gioza").addInvite(invitation);
    }

    public abstract GameDAO getGameDAO();

    public abstract GroupDAO getGroupDAO();

    public abstract InvitationDAO getInvitationDAO();

    public abstract OrganizerDAO getOrganizerDAO();

    public abstract ParticipationDAO getParticipationDAO();

    public abstract PlayerDAO getPlayerDAO();

    public abstract RoundDAO getRoundDAO();

    public abstract TeamDAO getTeamDAO();

    /**
     * Returns
     * @return Το DAO των χωρών
     */
    public abstract TournamentDAO getTournamentDAO();


}
