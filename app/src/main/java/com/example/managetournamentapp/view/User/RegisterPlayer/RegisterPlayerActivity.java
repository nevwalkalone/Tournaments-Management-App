package com.example.managetournamentapp.view.User.RegisterPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.view.HomePage.HomePageViewModel;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.fragment.TournamentListFragment;

public class RegisterPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    RegisterPlayerViewModel viewModel;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_player);

        final RegisterPlayerPresenter presenter = new RegisterPlayerPresenter(viewModel, new PlayerDAOMemory());
        saveBtn.setOnClickListener(this);

        viewModel = new ViewModelProvider(this).get(RegisterPlayerViewModel.class);

        getDetails();

    }

    public void getDetails() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.savePlayerBtn) {

        }

    }
}