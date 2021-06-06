package com.example.managetournamentapp.view.Player.PlayerInfo;

import androidx.appcompat.app.AlertDialog;

public interface PlayerInfoView {

    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);

    void setUsername(String username);

    void setPassword(String password);

    void setName(String name);

    void setSurname(String surname);

    void setPhone(String phone);

    void setEmail(String email);

    void setLocation(String location);

    void setBirthDate(String date);

    void startEditPlayer();

    void startDeletePlayer();

    void showCantDelete();

    void changesOfAccess();

    void displayPopUp(int layout, String msg, int btn1, int btn2);

    void dismissPopUp();

}
