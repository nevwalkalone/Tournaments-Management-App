package com.example.managetournamentapp.view.User.RegisterOrganizer;


import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;


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


    void setTitle(String title);

    void showPopUp(RegisterOrganizerView view, String msg);

    Organizer getConnectedOrganizer();

    void startOrganizerPage();

}
