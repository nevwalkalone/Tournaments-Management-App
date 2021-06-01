package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

public class RegisterPlayerActivity extends AppCompatActivity implements RegisterPlayerView, View.OnClickListener {

    RegisterPlayerViewModel viewModel;
    public static final String PLAYER_USERNAME = "PLAYER_USERNAME";
    private Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_player);

        viewModel = new ViewModelProvider(this).get(RegisterPlayerViewModel.class);
        viewModel.getPresenter().setView(this);

        final RegisterPlayerPresenter presenter = new RegisterPlayerPresenter();
        saveBtn = (Button) findViewById(R.id.savePlayerBtn);
        saveBtn.setOnClickListener(this);

    }


    public Player getConnectedPlayer() {
        if (this.getIntent().hasExtra("IS_EDIT") ){
            return (Player)(new MemoryLoggedInUser()).getUser();
        }else{
            return null;
        }
//        return this.getIntent().hasExtra("IS_EDIT") ? this.getIntent().getExtras().getString("PLAYER_USERNAME") : null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.savePlayerBtn) {
            viewModel.getPresenter().onSavePlayer();
        }

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
        return BIRTHDATE.getText().toString();      //
    }

    @Override
    public Credentials getCredentials() {
        return null;
    }

    @Override
    public String getLocation() {
        EditText LOCATION = (EditText) findViewById(R.id.location);
        return LOCATION.getText().toString();
    }

    @Override
    public AgeDivision getAgeDivision() {
        return null;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setSurname(String surname) {

    }

    @Override
    public void setPhoneNumber(String phoneNumber) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setBirthdate(String birthdate) {

    }

    @Override
    public void setCredentials(Credentials credentials) {

    }

    @Override
    public void setLocation(String location) {

    }

    @Override
    public void setAgeDivision(AgeDivision ageDivision) {

    }
}