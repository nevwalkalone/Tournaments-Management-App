package com.example.managetournamentapp.view.User.Login;


public interface LoginView {

    String getUsername();

    String getPassword();

    void showPopUp(LoginView view, String msg);

    void startPlayerPage(String username);

    void startOrganizerPage();

}
