package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

public class OrganizerInfoViewStub implements OrganizerInfoView {
    String username, password, name, surname, phone, email, birthdate, title;

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setBirthDate(String date) {
        this.birthdate = date;
    }

    @Override
    public void startEditOrganizer(String organizerUsername) {

    }

    @Override
    public void startDeleteOrganizer() {

    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void showCantDelete() {

    }
}