package com.example.managetournamentapp.view.Player.ReceivedInvites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.view.Player.CreateTeam.CreateTeamActivity;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsView;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsViewModel;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.TeamsListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ReceivedInvitesActivity extends AppCompatActivity implements ReceivedInvitesView, TeamsListFragment.OnListFragmentInteractionListener {


    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    JoinedTeamsViewModel viewModel;
    private FloatingActionButton addBtn;
    private String playerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_invites);
        playerUsername = this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(JoinedTeamsViewModel.class);
//        viewModel.getPresenter().setView(this);
        addBtn = findViewById(R.id.create_team_button);
        addBtn.setOnClickListener(v -> viewModel.getPresenter().onAddTeam());

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            viewModel.getPresenter().findJoinedTeams(playerUsername);


            TeamsListFragment teamsListFragment = TeamsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, teamsListFragment)
                    .commit();
        }
        // viewModel.getPresenter().findAccess();
    }

    @Override
    public void onListFragmentInteraction(Team item) {
        Intent intent = new Intent(ReceivedInvitesActivity.this, TeamPageActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, item.getName());
        startActivity(intent);
    }

    @Override
    public ArrayList<Team> getTeamsList() {
        return null;
    }


}