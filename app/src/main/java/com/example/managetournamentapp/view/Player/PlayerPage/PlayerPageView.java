package com.example.managetournamentapp.view.Player.PlayerPage;

public interface PlayerPageView {

    void toPlayerInfo(String playerUsername);

    void toPlayerTeams(String playerUsername);

    void toPlayerInvites(String playerUsername);

    void changesOfAccess();

    void logOut();

}
