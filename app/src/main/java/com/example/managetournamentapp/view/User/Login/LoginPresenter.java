package com.example.managetournamentapp.view.User.Login;


import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;


public class LoginPresenter {

    private LoginView view;
    private PlayerDAO playerDAO;
    private OrganizerDAO organizerDAO;
    private LoggedInUser loggedInUser;

    public LoginPresenter() {
    }

    /**
     * This method check in both PlayerDAO and OrganizerDAO via credentials.
     *
     * @param username user input
     * @param password user input
     */
    public void checkInDAO(String username, String password) {
        Credentials credCheck = new Credentials(username, password);
        if (organizerDAO.verify(credCheck)) {
            Organizer loggedInOrganizer = organizerDAO.findByCredentials(credCheck);           // Try to find the Organizer in DAO and set it as current LoggedInUser
            loggedInUser.setUser(loggedInOrganizer);
            view.startOrganizerPage();
        } else if (playerDAO.verify(credCheck)) {
            Player loggedInPlayer = playerDAO.find(credCheck.getUsername());                   // Try to find the Player in DAO and set it as current LoggedInUser
            loggedInUser.setUser(loggedInPlayer);
            view.startPlayerPage(username);
        } else {
            view.showPopUp(view, "Invalid credentials. We didn't find any user with these credentials.");
        }
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void setOrganizerDAO(OrganizerDAO organizerDAO) {
        this.organizerDAO = organizerDAO;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Check for input validation and existence of Credentials in DAOs.
     */
    public void validateCredentials() {
        String usename = view.getUsername();
        String password = view.getPassword();
        if (usename.length() < 5 || usename.length() > 20)
            view.showPopUp(view, "Username must be at least 5 chars and no longer than 20 chars!");
        else if (password.length() < 5)
            view.showPopUp(view, "Password must be at least 5 chars!");
        else {
            checkInDAO(usename, password);
        }
    }
}
