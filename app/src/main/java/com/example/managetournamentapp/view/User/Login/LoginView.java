package com.example.managetournamentapp.view.User.Login;

import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerView;

public interface LoginView {

    String getUsername();

    String getPassword();

    void showPopUp(RegisterPlayerView view, String msg);

}
