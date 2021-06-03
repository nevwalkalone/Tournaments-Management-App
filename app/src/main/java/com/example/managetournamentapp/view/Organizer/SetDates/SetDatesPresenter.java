package com.example.managetournamentapp.view.Organizer.SetDates;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Tournament;

import java.util.ArrayList;

public class SetDatesPresenter {
    private SetDatesView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<String> basicInfo;
    private String teamsNumber;

    public SetDatesPresenter() { }


    public void findBasicInfo(ArrayList<String> basicInfo){
        this.basicInfo = basicInfo;
        teamsNumber = basicInfo.get(5);
    }

    public void onSaveTournament(){
        if(false){

        }else{
            tournamentDAO.save( new Tournament() );
            view.startSaveTournament(basicInfo.get(0));
        }
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void setView(SetDatesView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }
}
