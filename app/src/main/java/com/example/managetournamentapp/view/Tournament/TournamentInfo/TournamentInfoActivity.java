package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentActivity;

public class TournamentInfoActivity extends AppCompatActivity implements TournamentInfoView {
    private TournamentInfoViewModel viewModel;
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    String tournamentName;
    Button btnEditTournament;
    Button btnDeleteTournament;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);
        tournamentName = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        viewModel = new ViewModelProvider(this).get(TournamentInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findTournamentInfo(tournamentName);

        btnEditTournament = findViewById(R.id.edit_button);
        btnDeleteTournament = findViewById(R.id.delete_button);

        btnEditTournament.setOnClickListener(v -> viewModel.getPresenter().onEditTournament());
        btnDeleteTournament.setOnClickListener(v -> viewModel.getPresenter().onDeleteTournament());

        viewModel.getPresenter().findAccess();
    }

    @Override
    public void setTeamsNumber(String teamsNumber) {
        ((TextView)findViewById(R.id.text_teams_number)).setText(teamsNumber);
    }

    @Override
    public void setLocation(String location) {
        ((TextView)findViewById(R.id.text_location)).setText(location);
    }

    @Override
    public void setStartDate(String startDate) {
        ((TextView)findViewById(R.id.text_start_date)).setText(startDate);
    }

    @Override
    public void setFinishDate(String finishDate) {
        ((TextView)findViewById(R.id.text_finish_date)).setText(finishDate);
    }

    @Override
    public void setsportType(String sportType) {
        ((TextView)findViewById(R.id.text_sport_type)).setText(sportType);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.text_title)).setText(title);
    }

    @Override
    public void setAgeDivision(String ageDivision) {
        ((TextView)findViewById(R.id.text_age_division)).setText(ageDivision);
    }

    @Override
    public void setDescription(String description) {
        ((TextView)findViewById(R.id.text_description)).setText(description);
    }

    @Override
    public void startEditTournament() {
        Intent intent = new Intent(TournamentInfoActivity.this, CreateTournamentActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA,tournamentName);
        startActivity(intent);
    }

    @Override
    public void startDeleteTournament() {

    }

    @Override
    public void changesOfAccess() {
        btnEditTournament.setVisibility(View.GONE);
        btnDeleteTournament.setVisibility(View.GONE);
    }
}
