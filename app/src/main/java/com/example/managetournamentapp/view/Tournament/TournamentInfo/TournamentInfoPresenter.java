package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.time.format.DateTimeFormatter;

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
        if( tournament == null )
            return;

        view.setTitle(tournament.getTitle());
        view.setLocation(tournament.getLocation());
        view.setFinishDate(tournament.getFinishDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        view.setLocation(tournament.getLocation());
        view.setsportType(tournament.getSportType().getName());
        view.setStartDate(tournament.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        view.setTeamsNumber(String.valueOf(tournament.getMAX_TEAMS_NUMBER()));
        view.setAgeDivision(tournament.getAgeDivision().toString());
        view.setDescription(tournament.getDescription());

    }

    public void findAccess(){
        if (MemoryLoggedInUser.getUser() != null )
            if (MemoryLoggedInUser.getUser() instanceof Organizer)
                if ( ((Organizer)MemoryLoggedInUser.getUser()).getTournaments().contains(tournament) )
                    return;
        view.changesOfAccess();
    }

    //TODO CHECKING
    public void onEditTournament(){
        view.startEditTournament();
    }

    //TODO CHECKING
    public void onDeleteTournament(){
        view.deleteConfirmation();
    }

    public void onYesDeleteTournament(){
        view.yesDeleteTournament();
    }

    public void onNoDeleteTournament(){
        view.noDeleteTournament();
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
