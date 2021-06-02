package com.example.managetournamentapp.view.User.Login;

import android.content.Intent;

import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerView;

public interface LoginView {

    String getUsername();

    String getPassword();

    void showPopUp(LoginView view, String msg);

    void startPlayerPage();

    void startOrganizerPage();

}
