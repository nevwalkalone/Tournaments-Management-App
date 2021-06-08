package com.example.managetournamentapp.view.User.RegisterPlayer;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Sport;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public interface RegisterPlayerView {

    String getUsername();

    String getPassword();

    String getName();

    String getSurname();

    String getPhoneNumber();

    String getEmail();

    String getBirthDate();

    String getLocation();

    AgeDivision getAgeDivision();

    void setUsername(String username);

    void setPassword(String password);

    void setName(String name);

    void setSurname(String surname);

    void setPhoneNumber(String phoneNumber);

    void setEmail(String email);

    void setBirthdate(String birthdate);

    void setLocation(String location);

    ArrayList<Sport> getSportsInterest();

    void setSportsInterest(ArrayList<Sport> sports);

    void showPopUp(RegisterPlayerView view, String msg);

    void startPlayerPage();


}
