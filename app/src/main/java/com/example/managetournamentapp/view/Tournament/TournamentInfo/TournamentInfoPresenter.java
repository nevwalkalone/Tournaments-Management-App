package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoView;

public class TournamentInfoPresenter {
    private TournamentInfoView view;
    private Tournament tournament;
    private TournamentDAO tournamentDAO;

    public TournamentInfoPresenter(){
    }

    public void findTournamentInfo(String tournamentName){
        if(tournamentName ==null){
            return;
        }
        tournament = tournamentDAO.find(tournamentName);

        view.setTitle(tournament.getTitle());
        view.setLocation(tournament.getLocation());
        view.setFinishDate(tournament.getFinishDate().toString());
        view.setLocation(tournament.getLocation());
        view.setsportType(tournament.getSportType().getName());
        view.setStartDate(tournament.getStartDate().toString());
        view.setTeamsNumber(String.valueOf(tournament.getMAX_TEAMS_NUMBER()));
        view.setAgeDivision(tournament.getAgeDivision().toString());
        view.setDescription(tournament.getDescription());


    }

    //TODO CHECKING
    public void onEditTournament(){
        view.startEditTournament();
    }

    //TODO CHECKING
    public void onDeleteTournament(){
        tournamentDAO.delete(tournament);
        view.startDeleteTournament();
    }


    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(TournamentInfoView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }
}
