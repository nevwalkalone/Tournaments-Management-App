package com.example.managetournamentapp.view.Tournament.GroupRankings;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.TeamsListFragment;
import java.util.ArrayList;


public class GroupRankingsActivity extends AppCompatActivity implements GroupRankingsView,TeamsListFragment.OnListFragmentInteractionListener {

    public static final String  TOURNAMENT_TITLE_EXTRA= "tournament_title_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static final String SPECIFIC_GROUP_EXTRA = "specific_group_extra" ;
    GroupRankingsViewModel viewModel;
    private String tournamentTitle;
    private int specificGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_rankings);
        viewModel = new ViewModelProvider(this).get(GroupRankingsViewModel.class);
        viewModel.getPresenter().setView(this);

        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        specificGroup = Integer.parseInt( this.getIntent().getStringExtra(SPECIFIC_GROUP_EXTRA) );

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            viewModel.getPresenter().findTeams(tournamentTitle, specificGroup);
            TeamsListFragment teamsListFragment = TeamsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, teamsListFragment)
                    .commit();
        }
    }

    @Override
    public void onListFragmentInteraction(Team item) {
        if (item.getName()==null){
            Toast.makeText(this,"THE TEAM IS NOT SET", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent = new Intent(GroupRankingsActivity.this, TeamPageActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, item.getName());
        startActivity(intent);
    }

    @Override
    public ArrayList<Team> getTeamsList() {
        return viewModel.getPresenter().getResults();
    }

}
