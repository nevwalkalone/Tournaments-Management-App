package com.example.managetournamentapp.view.Tournament.TournamentPage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.ParticipatingTeamsActivity;
import com.example.managetournamentapp.view.Tournament.TournamentInfo.TournamentInfoActivity;

public class TournamentPageActivity extends AppCompatActivity implements TournamentPageView {
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    String tournamentName;
    private TournamentPageViewModel viewModel;
    TextView txtTournamentName;
    Button btnTournamentInfo;
    Button btnTournamentTeams;
    Button btnTournamentGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        tournamentName = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        System.out.println(tournamentName);
        setContentView(R.layout.activity_tournament_page);

        viewModel = new ViewModelProvider(this).get(TournamentPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtTournamentName = findViewById(R.id.text_tournament_name);
        btnTournamentInfo = findViewById(R.id.tournament_info_button);
        btnTournamentTeams = findViewById(R.id.tournament_teams_button);
        btnTournamentGames = findViewById(R.id.tournament_games_button);

        txtTournamentName.setText(tournamentName);
        btnTournamentInfo.setOnClickListener(v -> viewModel.getPresenter().onTournamentInfo());
        btnTournamentGames.setOnClickListener(v -> viewModel.getPresenter().onTournamentGames());
        btnTournamentTeams.setOnClickListener(v -> viewModel.getPresenter().onTournamentTeams());

    }





    @Override
    public void startTournamentInfo() {
        Intent intent = new Intent(TournamentPageActivity.this, TournamentInfoActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA,tournamentName);
        startActivity(intent);
    }

    @Override
    public void startTeamsParticipating() {
        Intent intent = new Intent(TournamentPageActivity.this, ParticipatingTeamsActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA,tournamentName);
        startActivity(intent);
    }

    @Override
    //TODO
    public void startTournamentGames() {

    }
}
