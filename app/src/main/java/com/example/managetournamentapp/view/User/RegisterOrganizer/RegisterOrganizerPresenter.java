package com.example.managetournamentapp.view.User.RegisterOrganizer;

import com.example.managetournamentapp.dao.LoggedInUser;
import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterOrganizerPresenter {

    private RegisterOrganizerView view;
    private OrganizerDAO organizerDAO;
    private Organizer connectedOrganizer;
    private LoggedInUser loggedInUser;

    public RegisterOrganizerPresenter() {

    }

    public void showPreviousInfo(String organizerTitle) {
        if (organizerTitle == null)
            return;
        connectedOrganizer = organizerDAO.findByTitle(organizerTitle);
        if (connectedOrganizer == null)
            return;

        if (connectedOrganizer != null)//edit mode
        {
            view.setName(connectedOrganizer.getName());
            view.setSurname(connectedOrganizer.getSurname());
            view.setUsername(connectedOrganizer.getCredentials().getUsername());
            view.setPassword(connectedOrganizer.getCredentials().getPassword());
            view.setPhoneNumber(connectedOrganizer.getPhoneNumber());
            view.setEmail(connectedOrganizer.getEmail());
            view.setBirthdate(connectedOrganizer.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            view.setTitle(connectedOrganizer.getTitle());
        }
    }


    public void handleOrganizerData() {
        String usename = view.getUsername();
        String password = view.getPassword();
        String name = view.getName();
        String surname = view.getSurname();
        String phoneNumber = view.getPhoneNumber();
        String email = view.getEmail();
        String birthDate = view.getBirthDate();
        String title = view.getOrganizerTitle();

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


        else {
            // IF USER IS NEW!
            if (connectedOrganizer == null) {
                birthDate = birthDate.replace("/", "-");
                Organizer organizer = new Organizer(name, surname, phoneNumber, email, LocalDate.parse(birthDate), new Credentials(usename, password), title);
                organizerDAO = new OrganizerDAOMemory();
                organizerDAO.save(organizer);
                loggedInUser.setUser(organizer);
                view.startOrganizerPage();
            } else {
                connectedOrganizer.setName(name);
                connectedOrganizer.setSurname(surname);
                birthDate = birthDate.replace("/", "-");
                String dateFormat = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-uuuu")).format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
                connectedOrganizer.setCredentials(new Credentials(usename, password));
                connectedOrganizer.setBirthDate(LocalDate.parse(dateFormat));
                connectedOrganizer.setTitle(title);
                connectedOrganizer.setPhoneNumber(phoneNumber);
                connectedOrganizer.setEmail(email);
                view.startOrganizerPage();

            }
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

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setView(RegisterOrganizerView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public void setOrganizerDAO(OrganizerDAO organizerDAO) {
        this.organizerDAO = organizerDAO;
    }

}
