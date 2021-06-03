package com.example.managetournamentapp.view.Team.TeamInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamActivity;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;


public class TeamInfoActivity  extends AppCompatActivity implements TeamInfoView {
    private TeamInfoViewModel viewModel;
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    String teamName;
    Button btnEditTeam;
    Button btnDeleteTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);

        teamName =  this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        viewModel = new ViewModelProvider(this).get(TeamInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findTeamInfo(teamName);

        btnEditTeam = findViewById(R.id.edit_team_button);
        btnDeleteTeam = findViewById(R.id.delete_team_button);

        btnEditTeam.setOnClickListener(v -> viewModel.getPresenter().onEditTeam());
        btnDeleteTeam.setOnClickListener(v -> viewModel.getPresenter().onDeleteTeam());

        viewModel.getPresenter().findAccess();
    }

    @Override
    public void setTeamName(String name) {
        ((TextView)findViewById(R.id.team_name)).setText(name);
    }

    @Override
    public void setColors(String colors) {
        ((TextView)findViewById(R.id.team_colors)).setText(colors);
    }

    @Override
    public void setAgeDivision(String division) {
        ((TextView)findViewById(R.id.age_division)).setText(division);
    }

    @Override
    public void setSport(String sport) {
        ((TextView)findViewById(R.id.sport_type)).setText(sport);
    }

    @Override
    public void startEditTeam() {
        Intent intent = new Intent(TeamInfoActivity.this, CreateTeamActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, teamName);
        startActivity(intent);
    }

    @Override
    public void startDeleteTeam(String playerUsername) {
        Intent intent = new Intent(TeamInfoActivity.this, JoinedTeamsActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, playerUsername);
        startActivity(intent);
    }

    @Override
    public void changesOfAccess() {
        btnEditTeam.setVisibility(View.GONE);
        btnDeleteTeam.setVisibility(View.GONE);
    }
}
