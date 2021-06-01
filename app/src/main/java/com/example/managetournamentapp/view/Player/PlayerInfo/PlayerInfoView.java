package com.example.managetournamentapp.view.Player.PlayerInfo;

import com.example.managetournamentapp.domain.Player;

public interface PlayerInfoView {


    void setUsername(String username);

    void setPassword(String password);

    void setName(String name);

    void setSurname(String surname);

    void setPhone(String phone);

    void setEmail(String email);

    void setLocation(String location);

    void setBirthDate(String date);

    void startEditPlayer(Player player);

    void startDeletePlayer(Player player);

}
