package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoView;

public class OrganizerInfoPresenter {
    private OrganizerInfoView view;
    private Organizer organizer = null;

    public OrganizerInfoPresenter(){}

    public void findOrganizerInfo() {
        view.setUsername(organizer.getCredentials().getUsername());
        view.setPassword(organizer.getCredentials().getPassword());
        view.setName(organizer.getName());
        view.setSurname(organizer.getSurname());
        view.setPhone(organizer.getPhoneNumber());
        view.setEmail(organizer.getEmail());
        view.setBirthDate(organizer.getBirthDate().toString());
        view.setTitle(organizer.getTitle());
    }

    public void onEditOrganizer() {
        view.startEditOrganizer(organizer);
    }

    public void onDeleteOrganizer() {
        view.startDeleteOrganizer(organizer);
    }

    public void setOrganizer(User user){
        if (user == null)
            return;
        if (!(user instanceof Organizer))
            return;
        organizer = (Organizer) user;

    }

    public void setView(OrganizerInfoView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }
}
