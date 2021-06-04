package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Round;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.time.format.DateTimeFormatter;


public class OrganizerInfoPresenter {
    private OrganizerInfoView view;
    private Organizer organizer = null;
    private OrganizerDAO organizerDAO;

    public OrganizerInfoPresenter(){}

    public void findOrganizerInfo() {
        view.setUsername(organizer.getCredentials().getUsername());
        view.setPassword(organizer.getCredentials().getPassword());
        view.setName(organizer.getName());
        view.setSurname(organizer.getSurname());
        view.setPhone(organizer.getPhoneNumber());
        view.setEmail(organizer.getEmail());
        view.setBirthDate(organizer.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        view.setTitle(organizer.getTitle());
    }

    public void onEditOrganizer() {
        view.startEditOrganizer(organizer.getTitle());
    }


    public void onDeleteOrganizer() {
        boolean canDelete = true;

        for (Tournament tournament : organizer.getTournaments())
            for ( Round round : tournament.getRounds())
                if ( !round.allGamesFinished() )
                    canDelete = false;

        if ( !canDelete ){
            view.showCantDelete();
            return;
        }
        organizerDAO.delete(organizer);
        (new MemoryLoggedInUser()).clear();
        view.startDeleteOrganizer();
    }

    public void setOrganizer(User user){
        if (user == null)
            return;
        if (!(user instanceof Organizer))
            return;
        organizer = (Organizer) user;

    }

    public void setOrganizerDAO(OrganizerDAO organizerDAO){
        this.organizerDAO = organizerDAO;
    }

    public void setView(OrganizerInfoView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }
}
