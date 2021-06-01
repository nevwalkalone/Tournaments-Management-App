package com.example.managetournamentapp.view.Player.PlayerInfo;


import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.User;

public class PlayerInfoPresenter {
    private PlayerInfoView view;
    private Player player;

    public PlayerInfoPresenter(){
    }

    public void findPlayerInfo(User user){
        if (user == null)
            return;
        if ( !(user instanceof Player) )
            return;

        player = (Player) user;
        System.out.println(player);
        view.setUsername(player.getCredentials().getUsername());
        view.setPassword(player.getCredentials().getPassword());
        view.setName(player.getName());
        view.setSurname(player.getSurname());
        view.setPhone(player.getPhoneNumber());
        view.setEmail(player.getEmail());
        view.setLocation(player.getLocation());
        view.setBirthDate(player.getBirthDate().toString());

    }

    public void onEditPlayer(){
        view.startEditPlayer( player );
    }

    public void onDeletePlayer(){
        view.startDeletePlayer( player );
    }


    public void setView(PlayerInfoView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

}
