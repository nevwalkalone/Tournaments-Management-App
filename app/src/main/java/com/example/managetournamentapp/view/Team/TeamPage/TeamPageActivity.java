package com.example.managetournamentapp.view.Team.TeamPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageView;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageViewModel;
import com.example.managetournamentapp.view.Team.ParticipatingTournaments.ParticipatingTournamentsActivity;

public class TeamPageActivity extends AppCompatActivity implements TeamPageView {
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    String teamName;
    private TeamPageViewModel viewModel;
    TextView txtTeamName;
    Button btnTeamInfo;
    Button btnTeamPlayers;
    Button btnTeamParticipations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();
        teamName =  this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_page);

//
//        Log.d("BookSearchActivity", "Search criteria: " + titleCriterion
//                + " " + authorCriterion);

        viewModel = new ViewModelProvider(this).get(TeamPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtTeamName = findViewById(R.id.text_team_name);
        btnTeamInfo = findViewById(R.id.team_info_button);
        btnTeamPlayers = findViewById(R.id.team_players_button);
        btnTeamParticipations = findViewById(R.id.team_participations_button);

        txtTeamName.setText( teamName);
        btnTeamInfo.setOnClickListener(v -> viewModel.getPresenter().onTeamInfo());
        btnTeamPlayers.setOnClickListener(v -> viewModel.getPresenter().onTeamPlayers());
        btnTeamParticipations.setOnClickListener(v -> viewModel.getPresenter().onTeamParticipations());

    }


    @Override
    public void startTeamInfo() {
//        Intent intent = new Intent(TeamPageActivity.this, PlayerInfoActivity.class);
//        startActivity(intent);
    }

    @Override
    public void startTeamPlayers() {
//        Intent intent = new Intent(TeamPageActivity.this, PlayerInfoActivity.class);
//        startActivity(intent);
    }

    @Override
    public void startTeamParticipations() {
        Intent intent = new Intent(TeamPageActivity.this, ParticipatingTournamentsActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, teamName);
        startActivity(intent);
    }
}
