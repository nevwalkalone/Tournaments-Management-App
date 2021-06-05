package com.example.managetournamentapp.view.User.RegisterPlayer;

import android.view.View;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.TournamentType;

import java.util.ArrayList;

public interface RegisterPlayerView {

    String getUsername();

    String getPassword();

    String getName();

    String getSurname();

    String getPhoneNumber();

    String getEmail();

    String getBirthDate();

    Credentials getCredentials();

    String getLocation();

    AgeDivision getAgeDivision();

    void setUsername(String username);

    void setPassword(String password);

    void setName(String name);

    void setSurname(String surname);

    void setPhoneNumber(String phoneNumber);

    void setEmail(String email);

    void setBirthdate(String birthdate);

    void setCredentials(Credentials credentials);

    void setLocation(String location);

    ArrayList<Sport> getSportsInterest();

    void setSportsInterest(ArrayList<Sport> sports);

    void showPopUp(RegisterPlayerView view, String msg);

    void startPlayerPage();



}
