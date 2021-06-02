package com.example.managetournamentapp.view.Player.PlayerInfo;


import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class PlayerInfoPresenter {
    private PlayerInfoView view;
    private Player player;
    private PlayerDAO playerDAO;
    private LoggedInUser loggedInUser;

    public PlayerInfoPresenter(){
    }

    public void findPlayerInfo(){
        view.setUsername(player.getCredentials().getUsername());
        view.setPassword(player.getCredentials().getPassword());
        view.setName(player.getName());
        view.setSurname(player.getSurname());
        view.setPhone(player.getPhoneNumber());
        view.setEmail(player.getEmail());
        view.setLocation(player.getLocation());
        view.setBirthDate(player.getBirthDate().toString());
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
        playerDAO.delete(player);
        (new MemoryLoggedInUser()).clear();
        view.startDeletePlayer();
    }

    public void setPlayer(User user){
        if (user == null)
            return;
        if ( !(user instanceof Player) )
            return;

        player = (Player) user;
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

}
