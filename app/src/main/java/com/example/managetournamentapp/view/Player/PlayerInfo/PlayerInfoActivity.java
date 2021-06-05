package com.example.managetournamentapp.view.Player.PlayerInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

    @Override //TODO AlertDialog
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);

        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);

        //no delete
        Button firstButton = (Button) customLayout.findViewById(btn1);
        //yes delete
        Button secondButton = (Button) customLayout.findViewById(btn2);

        textMsg.setText(msg);

        firstButton.setOnClickListener(v->viewModel.getPresenter().onNoDeletePlayer());
        secondButton.setOnClickListener(v->viewModel.getPresenter().onYesDeletePlayer());
        return dialog;
    }

    @Override
    public void setUsername(String username){
        ((TextView)findViewById(R.id.text_username)).setText(username);
    }

    @Override
    public void setPassword(String password){
        ((TextView)findViewById(R.id.text_password)).setText(password);
    }

    @Override
    public void setName(String name){
        ((TextView)findViewById(R.id.text_name)).setText(name);
    }

    @Override
    public void setSurname(String surname){
        ((TextView)findViewById(R.id.text_surname)).setText(surname);
    }

    @Override
    public void setPhone(String phone){
        ((TextView)findViewById(R.id.text_phone)).setText(phone);
    }

    @Override
    public void setEmail(String email){
        ((TextView)findViewById(R.id.text_email)).setText(email);
    }

    @Override
    public void setLocation(String location){
        ((TextView)findViewById(R.id.text_location)).setText(location);
    }

    @Override
    public void setBirthDate(String date){
        ((TextView)findViewById(R.id.text_birth_date)).setText(date);
    }

    @Override
    public void startEditPlayer(){
        Intent intent = new Intent(PlayerInfoActivity.this, RegisterPlayerActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA , playerUsername);
        startActivity(intent);
    }

    @Override
    public void startDeletePlayer(){
        Toast.makeText(this,"USER HAS BEEN DELETED. BACK TO HOME PAGE.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PlayerInfoActivity.this, HomePageActivity.class);
        startActivity(intent);
    }

    @Override
    public void showCantDelete() {
        Toast.makeText(this,"YOU CAN'T DELETE YOUR ACCOUNT. REASON: PARTICIPATING IN A TEAM", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changesOfAccess(){
        btnEditPlayer.setVisibility(View.GONE);
        btnDeletePlayer.setVisibility(View.GONE);
        (findViewById(R.id.password_row)).setVisibility(View.GONE);
    }
}
