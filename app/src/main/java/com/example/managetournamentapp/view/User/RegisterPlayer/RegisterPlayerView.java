package com.example.managetournamentapp.view.User.RegisterPlayer;

import android.view.View;

import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;

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

    void setAgeDivision(AgeDivision ageDivision);

    void showPopUp(RegisterPlayerView view, String msg);

    Player getConnectedPlayer();

    void startPlayerPage();

}
