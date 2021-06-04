package com.example.managetournamentapp.view.Player.PlayerInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.HomePage.HomePageActivity;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerActivity;


public class PlayerInfoActivity extends AppCompatActivity implements PlayerInfoView {
    private PlayerInfoViewModel viewModel;
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";

    Button btnEditPlayer;
    Button btnDeletePlayer;
    String playerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        playerUsername = this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);

        setContentView(R.layout.activity_player_info);

        viewModel = new ViewModelProvider(this).get(PlayerInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findPlayerInfo(playerUsername);

        btnEditPlayer = findViewById(R.id.edit_player_button);
        btnDeletePlayer = findViewById(R.id.delete_player_button);
        btnEditPlayer.setOnClickListener(v -> viewModel.getPresenter().onEditPlayer());
        btnDeletePlayer.setOnClickListener(v -> viewModel.getPresenter().onDeletePlayer());

        viewModel.getPresenter().findAccess();
    }

//    @Override
//    public void onBackPressed(){
//        super.onBackPressed();
//        Intent intent = new Intent(PlayerInfoActivity.this, RegisterPlayerActivity.class);
//        intent.putExtra(PLAYER_USERNAME_EXTRA , playerUsername);
//        startActivity(intent);
//    }



    public void setUsername(String username){
        ((TextView)findViewById(R.id.text_username)).setText(username);
    }

    public void setPassword(String password){
        ((TextView)findViewById(R.id.text_password)).setText(password);
    }

    public void setName(String name){
        ((TextView)findViewById(R.id.text_name)).setText(name);
    }

    public void setSurname(String surname){
        ((TextView)findViewById(R.id.text_surname)).setText(surname);
    }

    public void setPhone(String phone){
        ((TextView)findViewById(R.id.text_phone)).setText(phone);
    }

    public void setEmail(String email){
        ((TextView)findViewById(R.id.text_email)).setText(email);
    }

    public void setLocation(String location){
        ((TextView)findViewById(R.id.text_location)).setText(location);
    }

    public void setBirthDate(String date){
        ((TextView)findViewById(R.id.text_birth_date)).setText(date);
    }

    public void startEditPlayer(){
        Intent intent = new Intent(PlayerInfoActivity.this, RegisterPlayerActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA , playerUsername);
        startActivity(intent);
    }

    public void startDeletePlayer(){
        Intent intent = new Intent(PlayerInfoActivity.this, HomePageActivity.class);
        startActivity(intent);
    }

    public void changesOfAccess(){
        btnEditPlayer.setVisibility(View.GONE);
        btnDeletePlayer.setVisibility(View.GONE);
        (findViewById(R.id.password_row)).setVisibility(View.GONE);

    }
}
