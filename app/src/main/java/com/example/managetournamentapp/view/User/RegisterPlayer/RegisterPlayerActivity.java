package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.AgeDivision;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;

import org.w3c.dom.Text;

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


    public Player getConnectedPlayer() {
        if (this.getIntent().hasExtra("IS_EDIT")) {
            return (Player) (new MemoryLoggedInUser()).getUser();
        } else {
            return null;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.savePlayerBtn) {
            if (viewModel.getPresenter().handlePlayerData()) {
                Intent intent = new Intent(this, PlayerPageActivity.class);
                startActivity(intent);
            }
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
    public void setAgeDivision(AgeDivision ageDivision) {
        //TODO

    }
}