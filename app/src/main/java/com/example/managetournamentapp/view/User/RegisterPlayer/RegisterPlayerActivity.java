package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.TextView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.view.HomePage.HomePageActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;


import java.util.ArrayList;

public class RegisterPlayerActivity extends AppCompatActivity implements RegisterPlayerView, View.OnClickListener {

    RegisterPlayerViewModel viewModel;
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private Button saveBtn;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    String playerUsername;

    private ArrayList<Sport> sportsInterest = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_player);
        System.out.println("PLAYER REGISTRATION CURRENT PAGE");
        playerUsername = this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);
        viewModel = new ViewModelProvider(this).get(RegisterPlayerViewModel.class);
        viewModel.getPresenter().setView(this);

        saveBtn = (Button) findViewById(R.id.savePlayerBtn);
        saveBtn.setOnClickListener(this);

        checkBox1 = (CheckBox) findViewById(R.id.radio_button_basketball3v3);
        checkBox2 = (CheckBox) findViewById(R.id.radio_button_basketball5v5);
        checkBox3 = (CheckBox) findViewById(R.id.radio_button_football5v5);
        checkBox4 = (CheckBox) findViewById(R.id.radio_button_football7v7);
        checkBox5 = (CheckBox) findViewById(R.id.radio_button_volleyball3v3);
        checkBox6 = (CheckBox) findViewById(R.id.radio_button_volleyball6v6);

        viewModel.getPresenter().showPreviousInfo(playerUsername);
    }

    //    // TODO OVERRIDE BACK PRESS
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(this, HomePageActivity.class);
//        startActivity(intent);
//    }
    @Override
    public void showPopUp(RegisterPlayerView view, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();
        Button OKbtn = (Button) customLayout.findViewById(R.id.OK_popup);
        TextView errorMsg = (TextView) customLayout.findViewById(R.id.error_messsage);      // display message we want.
        errorMsg.setText(msg);
        OKbtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.savePlayerBtn) {
            System.out.println("SAVE BUTTON PRESSED!");
            handleSportsInterest();
            viewModel.getPresenter().handlePlayerData();

        }
    }

    public void startPlayerPage() {
        Intent intent = new Intent(this, PlayerPageActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, getUsername());
        startActivity(intent);
    }


    @Override
    public String getUsername() {
        EditText USERNAME = (EditText) findViewById(R.id.username);
        return USERNAME.getText().toString();
    }

    @Override
    public String getPassword() {
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        return PASSWORD.getText().toString();
    }

    @Override
    public String getName() {
        EditText NAME = (EditText) findViewById(R.id.name);
        return NAME.getText().toString();
    }

    @Override
    public String getSurname() {
        EditText SURNAME = (EditText) findViewById(R.id.surname);
        return SURNAME.getText().toString();
    }

    @Override
    public String getPhoneNumber() {
        EditText PHONE = (EditText) findViewById(R.id.phone);
        return PHONE.getText().toString();
    }

    @Override
    public String getEmail() {
        EditText EMAIL = (EditText) findViewById(R.id.email);
        return EMAIL.getText().toString();
    }

    @Override
    public String getBirthDate() {
        EditText BIRTHDATE = (EditText) findViewById(R.id.birthdate);
        return BIRTHDATE.getText().toString();
    }

    @Override
    public Credentials getCredentials() {

        EditText USERNAME = (EditText) findViewById(R.id.username);
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        return new Credentials(USERNAME.getText().toString(), PASSWORD.getText().toString());
    }

    @Override
    public String getLocation() {
        EditText LOCATION = (EditText) findViewById(R.id.location);
        return LOCATION.getText().toString();
    }

    @Override
    public AgeDivision getAgeDivision() {
        //TODO Change Birthdate edit text and add here
        return AgeDivision.K15;
    }

    @Override
    public void setUsername(String username) {
        EditText USERNAME = (EditText) findViewById(R.id.username);
        USERNAME.setText(username);
    }

    @Override
    public void setPassword(String password) {
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        PASSWORD.setText(password);
    }

    @Override
    public void setName(String name) {
        EditText NAME = (EditText) findViewById(R.id.name);
        NAME.setText(name);
    }

    @Override
    public void setSurname(String surname) {
        EditText SURNAME = (EditText) findViewById(R.id.surname);
        SURNAME.setText(surname);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        EditText PHONE = (EditText) findViewById(R.id.phone);
        PHONE.setText(phoneNumber);
    }

    @Override
    public void setEmail(String email) {
        EditText EMAIL = (EditText) findViewById(R.id.email);
        EMAIL.setText(email);
    }

    @Override
    public void setBirthdate(String birthdate) {
        EditText BIRTHDATE = (EditText) findViewById(R.id.birthdate);
        BIRTHDATE.setText(birthdate);
    }

    @Override
    public void setCredentials(Credentials credentials) {
        //TODO

    }

    @Override
    public void setLocation(String location) {
        EditText LOCATION = (EditText) findViewById(R.id.location);
        LOCATION.setText(location);
    }

    @Override
    public ArrayList<Sport> getSportsInterest() {
        return this.sportsInterest;

    }

    public void handleSportsInterest() {
        if (checkBox1.isChecked())
            sportsInterest.add(new Sport("Basketball3v3"));
        else {
            sportsInterest.remove(new Sport("Basketball3v3"));
        }
        if (checkBox2.isChecked())
            sportsInterest.add(new Sport("Basketball5v5"));
        else {
            sportsInterest.remove(new Sport("Basketball5v5"));
        }
        if (checkBox3.isChecked())
            sportsInterest.add(new Sport("Football5v5"));
        else {
            sportsInterest.remove(new Sport("Football5v5"));
        }
        if (checkBox4.isChecked())
            sportsInterest.add(new Sport("Football7v7"));
        else {
            sportsInterest.remove(new Sport("Football7v7"));
        }
        if (checkBox5.isChecked())
            sportsInterest.add(new Sport("Volleyball3v3"));
        else {
            sportsInterest.remove(new Sport("Volleyball3v3"));
        }
        if (checkBox6.isChecked())
            sportsInterest.add(new Sport("Volleyball6v6"));
        else {
            sportsInterest.remove(new Sport("Volleyball6v6"));
        }
        System.out.println("Handle: " + sportsInterest);
    }

    @Override
    public void setSportsInterest(ArrayList<Sport> sports) {
        System.out.println("Set sport: " + sports);
        if (sports.contains(new Sport("Basketball3v3")))
            checkBox1.setChecked(true);
        if (sports.contains(new Sport("Basketball5v5")))
            checkBox2.setChecked(true);
        if (sports.contains(new Sport("Football5v5")))
            checkBox3.setChecked(true);
        if (sports.contains(new Sport("Football7v7")))
            checkBox4.setChecked(true);
        if (sports.contains(new Sport("Volleyball3v3")))
            checkBox5.setChecked(true);
        if (sports.contains(new Sport("Volleyball6v6")))
            checkBox6.setChecked(true);


    }

}