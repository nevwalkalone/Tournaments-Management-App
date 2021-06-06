package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.TeamsListFragment;

import java.util.ArrayList;

public class ParticipatingTeamsActivity extends AppCompatActivity implements ParticipatingTeamsView, TeamsListFragment.OnListFragmentInteractionListener {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    ParticipatingTeamsViewModel viewModel;
    String tournamentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participating_teams);
        viewModel = new ViewModelProvider(this).get(ParticipatingTeamsViewModel.class);
        viewModel.getPresenter().setView(this);
        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            System.out.println(this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA));
            viewModel.getPresenter().findParticipatingTeams(tournamentTitle);
//
            TeamsListFragment teamsListFragment = TeamsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, teamsListFragment)
                    .commit();
        }
    }

    @Override
    public void onListFragmentInteraction(Team item) {
        viewModel.getPresenter().onTeamSelected(item);
    }

    @Override
    public ArrayList<Team> getTeamsList() {
        return viewModel.getPresenter().getResults();
    }


    @Override
    public void checkTeam() {

    }

    @Override
    public void startTeamPage(String teamname) {
        Intent intent = new Intent(ParticipatingTeamsActivity.this, TeamPageActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, teamname);
        startActivity(intent);
    }
}
