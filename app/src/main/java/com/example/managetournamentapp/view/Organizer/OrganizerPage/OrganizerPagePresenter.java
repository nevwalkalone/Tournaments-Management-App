package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.User;

public class OrganizerPagePresenter {
    private OrganizerPageView view;
    private LoggedInUser loggedInUser;
    private Organizer organizer;
    private OrganizerDAO organizerDAO;

    public OrganizerPagePresenter() {

    }

    public void findOrganizerInfo(String organizerTitle) {
        if (organizerTitle == null) {
            return;
        }
        organizer = organizerDAO.findByTitle(organizerTitle);
    }

    public String getOrganizerTitle() {
        if (organizer == null) {
            return "";
        }
        return organizer.getTitle();
    }

    public void setOrganizer(User user) {
        if (user == null)
            return;
        if (!(user instanceof Organizer))
            return;
        organizer = (Organizer) user;

    }

    public void setOrganizerDAO(OrganizerDAO organizerDAO) {
        this.organizerDAO = organizerDAO;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void onOrganizerAccount() {
        view.toOrganizerAccount();
    }

    public void onOrganizerTournaments() {
        view.toOrganizerTournaments(organizer.getTitle());
    }

    public void onLogOut() {
        view.logOutConfirmation();
    }


    public void onNoLogOut() {
        view.noLogOut();
    }

    public void onYesLogOut() {
        loggedInUser.clear();
        view.logOut();
    }

    public void setView(OrganizerPageView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }
}
