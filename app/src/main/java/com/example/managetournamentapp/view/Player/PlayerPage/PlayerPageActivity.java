package com.example.managetournamentapp.view.Player.PlayerPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsViewModel;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.ParticipatingTeamsListFragment;

public class PlayerPageActivity extends AppCompatActivity implements  PlayerPageView{
    private PlayerPageViewModel viewModel;
    TextView txtPlayerName;
    Button btnPlayerAccount;
    Button btnPlayerTeams;
    Button btnPlayerInvites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);

//
//        Log.d("BookSearchActivity", "Search criteria: " + titleCriterion
//                + " " + authorCriterion);

        viewModel = new ViewModelProvider(this).get(PlayerPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtPlayerName = findViewById(R.id.title_player_name);
        btnPlayerAccount = findViewById(R.id.player_account);
        btnPlayerTeams = findViewById(R.id.player_teams);
        btnPlayerInvites = findViewById(R.id.player_invites);

        txtPlayerName.setText( ((Player) (new MemoryLoggedInUser()).getUser()).getName() );
        btnPlayerAccount.setOnClickListener(v -> viewModel.getPresenter().onPlayerAccount());
        btnPlayerTeams.setOnClickListener(v -> viewModel.getPresenter().onPlayerTeams());
        btnPlayerInvites.setOnClickListener(v -> viewModel.getPresenter().onPlayerInvites());

    }





}
