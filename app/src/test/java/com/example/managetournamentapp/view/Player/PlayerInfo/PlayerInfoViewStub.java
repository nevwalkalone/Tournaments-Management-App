package com.example.managetournamentapp.view.Player.PlayerInfo;

import androidx.appcompat.app.AlertDialog;

public class PlayerInfoViewStub implements PlayerInfoView {
    AlertDialog dialog;
    String username, password, name, surname, phone, email, location, birthdate;

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        return this.dialog;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setBirthDate(String date) {
        this.birthdate = date;
    }

    @Override
    public void startEditPlayer() {

    }

    @Override
    public void startDeletePlayer() {

    }

    @Override
    public void showCantDelete() {

    }

    @Override
    public void changesOfAccess() {

    }

    @Override
    public void displayPopUp(int layout, String msg, int btn1, int btn2) {
//        this.dialog = d(layout, msg, btn1, btn2);
//        this.dialog.show();
    }

    @Override
    public void dismissPopUp() {

    }
}
