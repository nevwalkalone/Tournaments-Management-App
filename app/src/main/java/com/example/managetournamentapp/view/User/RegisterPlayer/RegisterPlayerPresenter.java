package com.example.managetournamentapp.view.User.RegisterPlayer;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPlayerPresenter {

    private RegisterPlayerView view;
    private PlayerDAO playerDAO;
    private Player connectedPlayer;

    public RegisterPlayerPresenter() {


    }

    public void showPreviousInfo() {
        this.connectedPlayer = view.getConnectedPlayer();
        if (connectedPlayer != null)//edit mode
        {

            view.setName(connectedPlayer.getName());
            view.setSurname(connectedPlayer.getSurname());
            view.setUsername(connectedPlayer.getCredentials().getUsername());
            view.setPassword(connectedPlayer.getCredentials().getPassword());
            view.setPhoneNumber(connectedPlayer.getPhoneNumber());
            view.setEmail(connectedPlayer.getEmail());
            view.setBirthdate(connectedPlayer.getBirthDate().toString());
            view.setLocation(connectedPlayer.getLocation());
        }
    }

    public boolean handlePlayerData() {
        String usename = view.getUsername();
        String password = view.getPassword();
        String name = view.getName();
        String surname = view.getSurname();
        String phoneNumber = view.getPhoneNumber();
        String email = view.getEmail();
        String birthDate = view.getBirthDate();
        String location = view.getLocation();

        // validate user data
        if (usename.length() < 5 || usename.length() > 20)
            view.showPopUp(view, "Username must be at least 5 chars and no longer than 20 chars!");
        else if (password.length() < 5)
            view.showPopUp(view, "Password must be at least 5 chars!");
        else if (name.length() < 2 || !validateName(name))
            view.showPopUp(view, "Name must be at least 2 chars and only alphabetical chars!");
        else if (surname.length() < 2 || !validateName(surname))
            view.showPopUp(view, "Surname must be at least 2 chars and only alphabetical chars!");
        else if (phoneNumber.length() != 10)
            view.showPopUp(view, "Phone number must contain 10 numbers!");
        else if (email.length() < 2 || !checkEmail(email))
            view.showPopUp(view, "Not valid email!");
        else if (location.length() < 2 || !validateName(location))
            view.showPopUp(view, "Location must be at least 2 chars and only alphabetical chars!");
        else {
            // IF USER IS NEW!
            if (view.getConnectedPlayer() == null) {
                birthDate = birthDate.replace("/", "-");
                Player player = new Player(name, surname, location, phoneNumber, email, LocalDate.parse(birthDate), new Credentials(usename, password));
                playerDAO = new PlayerDAOMemory();
                playerDAO.save(player);
                (new MemoryLoggedInUser()).setUser(player);


            } else {
                connectedPlayer.setName(name);
                connectedPlayer.setSurname(surname);
                connectedPlayer.setCredentials(new Credentials(usename, password));
                connectedPlayer.setBirthDate(LocalDate.parse(birthDate));
                connectedPlayer.setLocation(location);
                connectedPlayer.setPhoneNumber(phoneNumber);
                connectedPlayer.setEmail(email);


            }
            return true;
        }
        return false;
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

    public boolean validateName(String name) {
        String valid = "^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(valid);
        Matcher matcher = pattern.matcher(name);
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
