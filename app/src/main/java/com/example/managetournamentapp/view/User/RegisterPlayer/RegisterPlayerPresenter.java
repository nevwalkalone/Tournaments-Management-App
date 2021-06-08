package com.example.managetournamentapp.view.User.RegisterPlayer;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Developed for the purposes of University Lesson "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public class RegisterPlayerPresenter {

    private RegisterPlayerView view;
    private PlayerDAO playerDAO;
    private Player connectedPlayer = null;
    private LoggedInUser loggedInUser;


    public RegisterPlayerPresenter() {
    }

    public void showPreviousInfo(String playerUsername) {
        if (playerUsername == null)
            return;
        connectedPlayer = playerDAO.find(playerUsername);
        if (connectedPlayer == null)
            return;

        view.setName(connectedPlayer.getName());
        view.setSurname(connectedPlayer.getSurname());
        view.setUsername(connectedPlayer.getCredentials().getUsername());
        view.setPassword(connectedPlayer.getCredentials().getPassword());
        view.setPhoneNumber(connectedPlayer.getPhoneNumber());
        view.setEmail(connectedPlayer.getEmail());
        view.setBirthdate(connectedPlayer.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-","/") );
        view.setLocation(connectedPlayer.getLocation());
        view.setSportsInterest(connectedPlayer.getSportsInterested());
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
        ArrayList<Sport> sportsInterest = view.getSportsInterest();


        // validate user data
        if (usename.length() < 5 || usename.length() > 20)
            view.showPopUp(view, "Username must be at least 5 chars and no longer than 20 chars!");
        else if (password.length() < 5)
            view.showPopUp(view, "Password must be at least 5 chars!");
        else if (name.length() < 2 || !validateName(name))
            view.showPopUp(view, "Name must be at least 2 chars and only alphabetical chars!");
        else if (surname.length() < 2 || !validateName(surname))
            view.showPopUp(view, "Surname must be at least 2 chars and only alphabetical chars!");
        else if (phoneNumber.length() != 10 || !validatePhone(phoneNumber))
            view.showPopUp(view, "Phone number must contain 10 numbers!");
        else if (email.length() < 2 || !checkEmail(email))
            view.showPopUp(view, "Not valid email!");
        else if (location.length() < 2 || !validateName(location))
            view.showPopUp(view, "Location must be at least 2 chars and only alphabetical chars!");
        else if (!validateBirthdate(birthDate))
            view.showPopUp(view, "Not valid date!");

        else {
            // IF USER IS NEW!
            if (connectedPlayer == null) {
                Player player = new Player(name, surname, location, phoneNumber, email, LocalDate.parse(reformatBirthdate(birthDate)), new Credentials(usename, password));
                for (Sport sport : sportsInterest)
                    player.addSportInterested(sport);
                playerDAO.save(player);
                loggedInUser.setUser(player);

            } else {
                connectedPlayer.setName(name);
                connectedPlayer.setSurname(surname);
                connectedPlayer.setCredentials(new Credentials(usename, password));
                connectedPlayer.setBirthDate(LocalDate.parse(reformatBirthdate(birthDate)));
                connectedPlayer.setLocation(location);
                connectedPlayer.setPhoneNumber(phoneNumber);
                connectedPlayer.setEmail(email);
                connectedPlayer.clearSportsInterest();
                for (Sport sport : sportsInterest)
                    connectedPlayer.addSportInterested(sport);

            }
            view.startPlayerPage();
        }
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

    public boolean validatePhone(String phone) {
        String valid = "[0-9]+";
        Pattern pattern = Pattern.compile(valid);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public String reformatBirthdate(String birthdate) {
        birthdate = birthdate.replace("/", "-");
        String dateFormat = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd-MM-uuuu")).format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        return dateFormat;
    }


    public boolean validateBirthdate(String birthdate) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthdate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
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
