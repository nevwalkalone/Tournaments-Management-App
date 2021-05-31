package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.view.HomePage.HomePageViewModel;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageViewModel;

public class RegisterPlayerActivity extends AppCompatActivity implements  RegisterPlayerView, View.OnClickListener {

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

    public String getDetails() {
        EditText USERNAME = (EditText) findViewById(R.id.username);
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        EditText NAME = (EditText) findViewById(R.id.name);
        EditText SURNAME = (EditText) findViewById(R.id.surname);
        EditText PHONE = (EditText) findViewById(R.id.phone);
        EditText EMAIL = (EditText) findViewById(R.id.email);
        EditText LOCATION = (EditText) findViewById(R.id.location);
        EditText BIRTHDATE = (EditText) findViewById(R.id.birthdate);

        String details = USERNAME + " " + PASSWORD + " " + NAME + " " + SURNAME + " " + PHONE + " " + EMAIL + " " + LOCATION + " " + BIRTHDATE;
        System.out.println(details);
        return details;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.savePlayerBtn) {
            viewModel.getPresenter().onSavePlayer();
        }

    }
}