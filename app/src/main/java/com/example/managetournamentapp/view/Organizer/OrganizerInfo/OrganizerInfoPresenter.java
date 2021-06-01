package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoView;

public class OrganizerInfoPresenter {
    private OrganizerInfoView view;
    private Organizer organizer;

    public void findOrganizerInfo(User user){
        if (user == null)
            return;
        if ( !(user instanceof Organizer) )
            return;

        organizer = (Organizer) user;

        view.setUsername(organizer.getCredentials().getUsername());
        view.setPassword(organizer.getCredentials().getPassword());
        view.setName(organizer.getName());
        view.setSurname(organizer.getSurname());
        view.setPhone(organizer.getPhoneNumber());
        view.setEmail(organizer.getEmail());
        view.setBirthDate(organizer.getBirthDate().toString());
        //System.out.println(organizer.getTitle());
        view.setTitle(organizer.getTitle());
    }

    public void onEditOrganizer(){
        view.startEditOrganizer( organizer );
    }

    public void onDeletePlayer(){
        view.startDeleteOrganizer( organizer );
    }


    public void setView(OrganizerInfoView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }
}
