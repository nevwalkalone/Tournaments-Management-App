package com.example.managetournamentapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrganizerTest {

    private Organizer organizer;
    private Organizer organizer2;
    private Organizer organizer3;
    private Organizer organizer4;
    private LocalDate birthDate;
    private LocalDate birthDate2;
    private Credentials cred;
    private Credentials cred2;
    private Tournament tournament;

    @Before
    public void setUp() throws Exception {

        ArrayList<Tournament> tournaments = new ArrayList<>();
        ArrayList<Tournament> tournaments2 = new ArrayList<>();
        birthDate = LocalDate.parse("1969-06-05");
        birthDate2 = LocalDate.parse("1978-10-23");
        cred = new Credentials("nikos1", "1234567");
        cred2 = new Credentials("lemon", "tikatika");

        organizer = new Organizer("Nikos", "Nikopoulos", "69xxxxxxxx", "nikosnik@gmail.com", birthDate, cred, "ESKA");
        organizer2 = new Organizer("Nikos", "Nikopoulos", "69xxxxxxxx", "nikosnik@gmail.com", birthDate, cred, "ESKA");
        organizer3 = new Organizer("Kostas", "Kostas", "69xxxxxxxx", "kostakis@gmail.com", birthDate2, cred2, "ESKANA");
        organizer4 = new Organizer();

        ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
        for (int i = 0; i < 64; i++) {
            dates.add(LocalDate.now());
        }
        tournament = new Tournament("TOURNOUA1", LocalDate.parse("2021-08-01"), LocalDate.parse("2021-08-25"), "ATHENS", (new Sport("Basketball3v3")),
                32, AgeDivision.K15, dates);

    }


    @Test
    public void testEquals() {

        Assert.assertEquals(organizer2, organizer);

    }

    @Test
    public void testNotEquals() {

        Assert.assertNotEquals(organizer2, organizer3);
        Assert.assertNotEquals(organizer3, organizer);
        Assert.assertNotEquals(organizer4, organizer);

    }

    // Tester for toString()
    @Test
    public void testPrinting() {

        Assert.assertEquals(organizer2.toString(), organizer.toString());

    }

    // testers for Getters and Setter

    @Test
    public void getNameTest() {
        Assert.assertEquals("ESKA", organizer.getTitle());
    }


    @Test
    public void testSetterGetterTitle() {

        String newTitle = "EPSA";
        organizer3.setTitle(newTitle);
        Assert.assertEquals(newTitle, organizer3.getTitle());

    }

    /**
     * Tester for adding tournaments
     */
    @Test
    public void testAddTournament() {


        organizer.addTournament(tournament);
        Assert.assertEquals(1, organizer.getTournaments().size());
        Assert.assertEquals(tournament, organizer.getTournaments().get(0));
        Assert.assertTrue(organizer.getTournaments().contains(tournament));

    }

    /**
     * Tester for deleting tournaments
     */
    @Test
    public void testDeleteTournament() {

        organizer.deleteTournament(tournament);
        Assert.assertEquals(0, organizer.getTournaments().size());
        Assert.assertFalse(organizer.getTournaments().contains(tournament));

    }

    /**
     * Tester for change tournaments title ( before and after adding the tournament ).
     */
    @Test
    public void testChangeTournamentTitle() {

        organizer.changeTournamentTitle(tournament, "ESKANA2");
        organizer.addTournament(tournament);
        organizer.changeTournamentTitle(tournament, "EPSA_1");
        Assert.assertEquals("EPSA_1", organizer.getTournaments().get(0).getTitle());

    }

    /**
     * Tester for change tournaments location ( before and after adding the tournament ).
     */
    @Test
    public void testChangeTournamentLocation() {

        // test before add
        organizer.changeTournamentLocation(tournament, "THESSALONIKI");
        organizer.addTournament(tournament);

        //test after add but without Participation
        organizer.changeTournamentLocation(tournament, "THESSALONIKI");

        // test after all
        tournament.addParticipation(new Participation(tournament, new Team()));
        organizer.changeTournamentLocation(tournament, "THESSALONIKI");

        Assert.assertEquals("THESSALONIKI", organizer.getTournaments().get(0).getLocation());

    }

    /**
     * Tester for change tournaments description ( before and after adding the tournament ).
     */
    @Test
    public void testChangeTournamentDescription() {

        // test before add
        organizer.changeTournamentDescription(tournament, "BEST 3V3 LET'S GO");
        organizer.addTournament(tournament);

        //test after add
        organizer.changeTournamentDescription(tournament, "BEST 3V3 LET'S GO");

        Assert.assertEquals("BEST 3V3 LET'S GO", organizer.getTournaments().get(0).getDescription());

    }

    /**
     * Tester for setting tournaments.
     */
    @Test
    public void testSetTournaments() {

        ArrayList<Tournament> tournaments = new ArrayList<>();
        tournaments.add(new Tournament());
        tournaments.add(new Tournament());
        organizer.setTournaments(tournaments);

        Assert.assertEquals(tournaments, organizer.getTournaments());

    }

    /**
     * Tester for change tournaments sport ( before and after adding the tournament ).
     */
    @Test
    public void testChangeTournamentSport() {

        Sport newSport = new Sport("Volleyball6v6");

        // test before add
        organizer.changeTournamentSport(tournament, newSport);
        organizer.addTournament(tournament);

        //test after add but without Participation
        organizer.changeTournamentSport(tournament, newSport);

        // test after all
        tournament.addParticipation(new Participation(tournament, new Team()));
        organizer.changeTournamentSport(tournament, newSport);

        Assert.assertEquals(newSport, organizer.getTournaments().get(0).getSportType());


    }

    /**
     * Tester for change tournaments AgeDivision ( before and after adding the tournament ).
     */
    @Test
    public void testChangeTournamentAgeDivision() {

        // test before add
        organizer.changeTournamentAgeDivision(tournament, AgeDivision.K12);
        organizer.addTournament(tournament);

        //test after add but without Participation
        organizer.changeTournamentAgeDivision(tournament, AgeDivision.K12);

        // test after all
        tournament.addParticipation(new Participation(tournament, new Team()));
        organizer.changeTournamentAgeDivision(tournament, AgeDivision.K12);

        Assert.assertEquals(AgeDivision.K12, organizer.getTournaments().get(0).getAgeDivision());


    }

    /**
     * Tester for change tournaments start date ( before and after adding the tournament ).
     */
    @Test
    public void testChangeStartDate() {

        LocalDate newStartDate = LocalDate.parse("2021-08-05");

        // test before add
        organizer.changeStartDate(tournament, newStartDate);
        organizer.addTournament(tournament);

        //test after add but without Participation
        organizer.changeStartDate(tournament, newStartDate);

        // test after all
        tournament.addParticipation(new Participation(tournament, new Team()));
        organizer.changeStartDate(tournament, newStartDate);

        Assert.assertEquals(newStartDate, organizer.getTournaments().get(0).getStartDate());


    }

    /**
     * Tester for change tournaments finish date ( before and after adding the tournament ).
     */
    @Test
    public void testChangeFinishDate() {

        LocalDate newFinishDate = LocalDate.parse("2021-08-10");

        // test before add
        organizer.changeFinishDate(tournament, newFinishDate);
        organizer.addTournament(tournament);

        //test after add but without Participation
        organizer.changeFinishDate(tournament, newFinishDate);

        // test after all
        tournament.addParticipation(new Participation(tournament, new Team()));
        organizer.changeFinishDate(tournament, newFinishDate);

        Assert.assertEquals(newFinishDate, organizer.getTournaments().get(0).getFinishDate());


    }


}
