package com.example.managetournamentapp.view.User.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showPopUp(RegisterPlayerView view, String msg) {

    }
}