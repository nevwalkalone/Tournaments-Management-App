package com.example.managetournamentapp.view.Team.JoinedPlayers;

import androidx.appcompat.app.AlertDialog;

public class JoinedPlayersViewStub implements JoinedPlayersView{
    boolean onHome = false;
    @Override
    public void changesOfAccess(boolean flag, boolean flag2) {

    }

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        return null;
    }

    @Override
    public void startPlayerInfo() {

    }

    @Override
    public void startInvitePlayerPage() {

    }

    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2) {

    }

    @Override
    public void displayPopUpDeletion(int layout, String msg, int btn1, int btn2) {

    }

    @Override
    public void dismissPopUpAction() {

    }

    @Override
    public void dismissPopUpDeletion() {

    }

    @Override
    public void resetPopUps() {

    }

    @Override
    public void restartActivity() {

    }

    @Override
    public void backToHomePage(boolean flag, String string) {
onHome = true;
    }

    @Override
    public void showToast(String txt) {

    }
}
