package com.example.managetournamentapp.view.User.Login;

public class LoginViewStub implements com.example.managetournamentapp.view.User.Login.UserBrowsingView {
    String username="tommy0";
    String password="12345";

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void showPopUp(com.example.managetournamentapp.view.User.Login.UserBrowsingView view, String msg) {

    }

    @Override
    public void startPlayerPage(String username) {

    }

    @Override
    public void startOrganizerPage() {

    }
}
