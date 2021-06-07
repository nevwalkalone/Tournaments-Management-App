package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import androidx.appcompat.app.AlertDialog;

public interface OrganizerPageView {
    void toOrganizerAccount();

    void toOrganizerTournaments(String title);

    void setTitle(String title);

    void logOut();

    void displayPopUpAction(int layout, String msg, int btn1, int btn2);

    void dismissPopUpAction();

    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);

    void logOutConfirmation();

    void noLogOut();


}
