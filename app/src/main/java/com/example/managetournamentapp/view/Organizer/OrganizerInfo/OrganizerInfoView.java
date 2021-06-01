package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

public interface OrganizerInfoView {

    void setUsername(String username);

    void setPassword(String password);

    void setName(String name);

    void setSurname(String surname);

    void setPhone(String phone);

    void setEmail(String email);

    void setBirthDate(String date);

    void startEditOrganizer(Organizer organizer);

    void startDeleteOrganizer(Organizer organizer);

    void setTitle(String title);
}
