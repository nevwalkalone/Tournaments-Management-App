package com.example.managetournamentapp.view.User.RegisterOrganizer;

import android.view.View;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

public interface RegisterOrganizerView {

    String getUsername();

    String getPassword();

    String getName();

    String getSurname();

    String getPhoneNumber();

    String getEmail();

    String getBirthDate();

    Credentials getCredentials();

    String getOrganizerTitle();

    void setUsername(String username);

    void setPassword(String password);

    void setName(String name);

    void setSurname(String surname);

    void setPhoneNumber(String phoneNumber);

    void setEmail(String email);

    void setBirthdate(String birthdate);

    void setCredentials(Credentials credentials);

    void setTitle(String title);

    void showPopUp(RegisterOrganizerView view, String msg);

    Organizer getConnectedOrganizer();

    void startOrganizerPage();

}
