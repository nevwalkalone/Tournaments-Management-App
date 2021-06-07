package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.TournamentDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.time.format.DateTimeFormatter;

public class TournamentInfoPresenter {
    private TournamentInfoView view;
    private Tournament tournament;
    private TournamentDAO tournamentDAO;
    private LoggedInUser loggedInUser;

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
        view.setStartDate(tournament.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-","/"));
        view.setFinishDate(tournament.getFinishDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-","/"));
        view.setLocation(tournament.getLocation());
        view.setsportType(tournament.getSportType().getName());
        view.setTeamsNumber(String.valueOf(tournament.getMAX_TEAMS_NUMBER()));
        view.setAgeDivision(tournament.getAgeDivision().toString());
        view.setDescription(tournament.getDescription());

    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof Organizer)
                if ( ((Organizer)loggedInUser.getUser()).getTournaments().contains(tournament) )
                    return;
        view.changesOfAccess();
    }

    public void onEditTournament(){
        if (!tournament.getParticipations().isEmpty()){
            view.showToast("CAN'T EDIT: THERE ARE ACTIVE PARTICIPATIONS");
            return;
        }
        view.startEditTournament();
    }

    //TODO CHECKING
    public void onDeleteTournament(){
        if (!tournament.getParticipations().isEmpty()){
            view.showToast("CAN'T DELETE: THERE ARE ACTIVE PARTICIPATIONS");
            return;
        }

        ((Organizer)loggedInUser.getUser()).deleteTournament(tournament);
        tournamentDAO.delete(tournament);
        view.deleteConfirmation();
    }

    public void onYesDeleteTournament(){
        Organizer organizer = (Organizer) loggedInUser.getUser();
        view.yesDeleteTournament(organizer.getTitle());
    }

    public void onNoDeleteTournament(){
        view.noDeleteTournament();
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
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
