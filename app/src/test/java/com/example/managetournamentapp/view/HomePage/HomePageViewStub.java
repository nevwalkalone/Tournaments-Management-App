package com.example.managetournamentapp.view.HomePage;

public class HomePageViewStub implements HomePageView {
    boolean onConnect = false, onBrowse = false, onLogin = false, onRegister = false, onOrganizerRegister = false, onPlayerRegister = false;

    @Override
    public void connectAction() {
        onConnect = true;

    }

    @Override
    public void browseAction() {
        onBrowse = true;

    }

    @Override
    public void loginAction() {
        onLogin = true;

    }

    @Override
    public void registerAction() {
        onRegister = true;

    }

    @Override
    public void organizerRegisterAction() {
        onOrganizerRegister = true;

    }

    @Override
    public void playerRegisterAction() {
        onPlayerRegister = true;

    }
}
