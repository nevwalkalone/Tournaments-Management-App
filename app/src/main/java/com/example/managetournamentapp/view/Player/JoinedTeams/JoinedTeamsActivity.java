package com.example.managetournamentapp.view.Player.JoinedTeams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamActivity;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.TeamsListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class JoinedTeamsActivity extends AppCompatActivity implements JoinedTeamsView, TeamsListFragment.OnListFragmentInteractionListener {
//todo add to fragment

    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    JoinedTeamsViewModel viewModel;
    private FloatingActionButton addBtn;
    private String playerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joined_teams);
        playerUsername = this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(JoinedTeamsViewModel.class);
        viewModel.getPresenter().setView(this);
        addBtn = findViewById(R.id.create_team_button);
        addBtn.setOnClickListener(v -> viewModel.getPresenter().onAddTeam());

        if (findViewById(R.id.fragment_container) != null){

            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findJoinedTeams(playerUsername);


            TeamsListFragment teamsListFragment = TeamsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, teamsListFragment)
                    .commit();
        }
        viewModel.getPresenter().findAccess();
    }

    @Override
    public void onListFragmentInteraction(Team item) {
        Intent intent = new Intent(JoinedTeamsActivity.this, TeamPageActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, item.getName());
        startActivity(intent);
    }

    @Override
    public ArrayList<Team> getTeamsList() {
        return viewModel.getPresenter().getResults();
    }


    @Override
    public void startAddTeam() {
        Intent intent = new Intent(JoinedTeamsActivity.this, CreateTeamActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA , playerUsername);
        startActivity(intent);
    }

    public void changesOfAccess(){
        addBtn.setVisibility(View.GONE);
    }

}

