package com.example.managetournamentapp.view.Player.PlayerInfo;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.time.format.DateTimeFormatter;

public class PlayerInfoPresenter {
    private PlayerInfoView view;
    private Player player;
    private PlayerDAO playerDAO;
    private LoggedInUser loggedInUser;

    public PlayerInfoPresenter(){}

    public void findPlayerInfo(String playerUsername){
        if (playerUsername==null)
            return;
        player = playerDAO.find(playerUsername);
        if( player == null )
            return;

        view.setUsername(player.getCredentials().getUsername());
        view.setPassword(player.getCredentials().getPassword());
        view.setName(player.getName());
        view.setSurname(player.getSurname());
        view.setPhone(player.getPhoneNumber());
        view.setEmail(player.getEmail());
        view.setLocation(player.getLocation());
        view.setBirthDate(player.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-","/") );
    }

    public void findAccess(){
        if ( loggedInUser.getUser() != null )
            if (loggedInUser.getUser() instanceof  Player)
                if ( ((Player)loggedInUser.getUser()).equals(player) )
                    return;
        view.changesOfAccess();
    }

    public void onEditPlayer(){
        view.startEditPlayer();
    }

    public void onDeletePlayer(){
        if (player.getTeamsJoined().size()>0){
            view.showCantDelete();
            return;
        }
        playerDAO.delete(player);
        (new MemoryLoggedInUser()).clear();
        view.startDeletePlayer();
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setView(PlayerInfoView view) {
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void onNoDeletePlayer(){

    }

    public void onYesDeletePlayer(){

    }

}
