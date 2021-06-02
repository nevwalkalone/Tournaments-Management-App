package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.ParticipatingTeamsListFragment;
import java.util.ArrayList;

public class ParticipatingTeamsActivity extends AppCompatActivity implements ParticipatingTeamsView, ParticipatingTeamsListFragment.OnListFragmentInteractionListener {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    ParticipatingTeamsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participating_teams);


        viewModel = new ViewModelProvider(this).get(ParticipatingTeamsViewModel.class);
        viewModel.getPresenter().setView(this);


        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

            System.out.println(this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA));
            viewModel.getPresenter().findParticipatingTeams( (new TournamentDAOMemory()).find(this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA) ));
//
            ParticipatingTeamsListFragment teamsListFragment = ParticipatingTeamsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, teamsListFragment)
                    .commit();
        }
    }

    @Override
    public void onListFragmentInteraction(Team item) {
        Intent intent = new Intent(ParticipatingTeamsActivity.this, TeamPageActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, item.getName());
        startActivity(intent);
    }

    @Override
    public ArrayList<Team> getTeamsList() {
        return viewModel.getPresenter().getResults();
    }


    @Override
    public void checkTeam() {

    }
}
