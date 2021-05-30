package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.Tournament;
import java.util.ArrayList;

public class ParticipatingTournamentsPresenter {
    private ParticipatingTournamentsView view;
    private TournamentDAO tournamentDAO;
    private ArrayList<Tournament> results = new ArrayList<>();

    public ParticipatingTournamentsPresenter(){}

    public void findParticipatingTournaments(Team team){
        if (team!=null){
            results.clear();
            for (Participation p : team.getParticipations())
                results.add( p.getTournament()  );
        }
    }

    public ArrayList<Tournament> getResults() {
        return results;
    }

    public void onTournamentSelected(Tournament t){
        // todo
    }

    public void setView(ParticipatingTournamentsView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

}
