package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import androidx.appcompat.app.AlertDialog;

public class OrganizerPageViewStub implements OrganizerPageView {
    String title;

    @Override
    public void toOrganizerAccount() {

    }

    @Override
    public void toOrganizerTournaments(String title) {

    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void logOut() {

    }

    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2) {

    }

    @Override
    public void dismissPopUpAction() {

    }

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        return null;
    }

    @Override
    public void logOutConfirmation() {

    }

    @Override
    public void noLogOut() {

    }
}
