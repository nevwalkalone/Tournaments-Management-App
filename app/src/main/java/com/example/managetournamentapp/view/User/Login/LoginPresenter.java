package com.example.managetournamentapp.view.User.Login;

import android.view.View;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;

public class LoginPresenter {

    private LoginView view;
    private PlayerDAO playerDAO;
    private OrganizerDAO organizerDAO;

    public LoginPresenter() {

    }


    /**
     * This method check in both PlayerDAO and OrganizerDAO via credentials.
     * @param username user input
     * @param password user input
     * @return true, if User already exists at least in one DAO.
     */
    public boolean checkInDAO(String username, String password) {
        boolean found = false;
        playerDAO = new PlayerDAOMemory();
        organizerDAO = new OrganizerDAOMemory();
        Credentials credCheck = new Credentials(username, password);
        if (getOrganizerDAO().verify(credCheck)) {
            found = true;
            Organizer loggedInOrganizer = getOrganizerDAO().findByCredentials(credCheck);           // Try to find the Organizer in DAO and set it as current LoggedInUser
            (new MemoryLoggedInUser()).setUser(loggedInOrganizer);
        } else if (getPlayerDAO().verify(credCheck)) {
            found = true;
            Player loggedInPlayer = getPlayerDAO().find(credCheck.getUsername());                   // Try to find the Player in DAO and set it as current LoggedInUser
            (new MemoryLoggedInUser()).setUser(loggedInPlayer);
        }


        return found;

    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public PlayerDAO getPlayerDAO() {
        return playerDAO;
    }

    public OrganizerDAO getOrganizerDAO() {
        return organizerDAO;
    }

    /**
     *  Check for input validation and existence of Credentials in DAOs.
     * @return true if user exists and input data are valid.
     */
    public boolean validateCredentials() {
        String usename = view.getUsername();
        String password = view.getPassword();
        if (usename.length() < 5 || usename.length() > 20)
            view.showPopUp(view, "Username must be at least 5 chars and no longer than 20 chars!");
        else if (password.length() < 5)
            view.showPopUp(view, "Password must be at least 5 chars!");
        else {
            return checkInDAO(usename, password);
        }
        return false;
    }
}
