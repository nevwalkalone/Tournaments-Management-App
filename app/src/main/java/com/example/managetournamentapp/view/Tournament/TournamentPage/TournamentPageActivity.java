package com.example.managetournamentapp.view.Tournament.TournamentPage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.ParticipatingTeamsActivity;
import com.example.managetournamentapp.view.Tournament.TournamentInfo.TournamentInfoActivity;
import com.example.managetournamentapp.view.Tournament.TournamentRounds.TournamentRoundsActivity;

public class TournamentPageActivity extends AppCompatActivity implements TournamentPageView {
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    String tournamentName;
    private TournamentPageViewModel viewModel;
    TextView txtTournamentName;
    Button btnTournamentInfo;
    Button btnTournamentTeams;
    Button btnTournamentGames;
    ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        tournamentName = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        setContentView(R.layout.activity_tournament_page);

        viewModel = new ViewModelProvider(this).get(TournamentPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtTournamentName = findViewById(R.id.text_tournament_name);
        btnTournamentInfo = findViewById(R.id.tournament_info_button);
        btnTournamentTeams = findViewById(R.id.tournament_teams_button);
        btnTournamentGames = findViewById(R.id.tournament_games_button);
        btnHome = findViewById(R.id.imageButton);

        txtTournamentName.setText(tournamentName);
        btnTournamentInfo.setOnClickListener(v -> viewModel.getPresenter().onTournamentInfo());
        btnTournamentGames.setOnClickListener(v -> viewModel.getPresenter().onTournamentGames());
        btnTournamentTeams.setOnClickListener(v -> viewModel.getPresenter().onTournamentTeams());
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());

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
    public void startTournamentGames() {
        Intent intent = new Intent(TournamentPageActivity.this, TournamentRoundsActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA,tournamentName);
        startActivity(intent);
    }

    @Override
    public void backToHomePage(boolean isPlayer, String name) {
        if (isPlayer){
            Intent intent = new Intent(this, PlayerPageActivity.class);
            intent.putExtra(PLAYER_USERNAME_EXTRA,name);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent (this, OrganizerPageActivity.class);
            intent.putExtra(ORGANIZER_TITLE_EXTRA, name);
            startActivity(intent);
        }
    }
}
