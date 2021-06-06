package com.example.managetournamentapp.view.Tournament.GroupRankings;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationPresenter;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationView;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class GroupRankingsPresenterTest {

    private GroupRankingsPresenter presenter;
    private GroupRankingsView view;

    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new GroupRankingsViewStub();
        presenter = new GroupRankingsPresenter();
        presenter.setTournamentDAO(new TournamentDAOMemory());
        presenter.setView(view);

    }

//    @Test
//    public void testFindTeams(){
//        presenter.findTeams("TOURNOUA1", 0);
//
////        Player testPlayer = new Player("gioza", "zagio", "Athens", "6900000000", "aa@aa.aa", LocalDate.parse("2000-01-01"), new Credentials("gioza", "12345"));
////        testPlayer.addSportInterested(new Sport("Basketball3v3"));
////        players.add(testPlayer);
////        playerDAO.save(testPlayer);
////
////        Team testTeam1 = new Team("Celtic" + 10, (new Sport("Basketball3v3")), AgeDivision.K100, players.get(0), "green");
////        testTeam1.addPlayer(players.get(1));
////        testTeam1.addPlayer(players.get(2));
////        teamDAO.save(testTeam);
////        Team testTeam2 = new Team("Celtic" + 10, (new Sport("Basketball3v3")), AgeDivision.K100, players.get(0), "green");
////        testTeam2.addPlayer(players.get(1));
////        testTeam2.addPlayer(players.get(2));
////        teamDAO.save(testTeam);
////        Assert.assertTrue(presenter.getResults().contains()"Celtic0", );
//
//    }

}