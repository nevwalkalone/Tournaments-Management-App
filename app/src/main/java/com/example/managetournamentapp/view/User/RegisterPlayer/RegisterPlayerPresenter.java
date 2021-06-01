package com.example.managetournamentapp.view.User.RegisterPlayer;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPlayerPresenter {

    private RegisterPlayerView view;
    private PlayerDAO playerDAO;
    private Player connectedPlayer;

    public RegisterPlayerPresenter() {

    }

    public void handlePlayerData() {
        String usename = view.getUsername();
        String password = view.getPassword();
        String name = view.getName();
        String surname = view.getSurname();
        String phoneNumber = view.getPhoneNumber();
        String email = view.getEmail();
        String birthDate = view.getBirthDate();
        String location = view.getLocation();

        if (usename.length() < 5 || usename.length() > 20)
            view.showPopUp(view, "Username must be at least 5 chars and no longer than 20 chars!");
        else if (password.length() < 5)
            view.showPopUp(view, "Password must be at least 5 chars!");
        else if (phoneNumber.length() < 10)
            view.showPopUp(view, "Phone number must contain 10 numbers!");
        else if (email.length() < 2 || !checkEmail(email))
            view.showPopUp(view, "Not valid email!");


    }

    /**
     * @param emailToCheck the email we want to check if it's valid.
     * @return true if the email is valid, else false.
     */
    public boolean checkEmail(String emailToCheck) {
        String valid = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(valid);
        Matcher matcher = pattern.matcher(emailToCheck);
        return matcher.matches();
    }

    public void setView(RegisterPlayerView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

}
