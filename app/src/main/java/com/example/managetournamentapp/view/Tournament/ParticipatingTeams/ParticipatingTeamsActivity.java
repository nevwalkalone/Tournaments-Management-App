package com.example.managetournamentapp.view.Tournament.ParticipatingTeams;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.ParticipatingTeamsListFragment;
import java.util.ArrayList;

public class ParticipatingTeamsActivity extends AppCompatActivity implements ParticipatingTeamsListFragment.OnListFragmentInteractionListener {

    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    ParticipatingTeamsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participating_teams);
        Intent intent = getIntent();

//
//        Log.d("BookSearchActivity", "Search criteria: " + titleCriterion
//                + " " + authorCriterion);

        viewModel = new ViewModelProvider(this).get(ParticipatingTeamsViewModel.class);

        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findParticipatingTeams( (new TournamentDAOMemory()).find("TOURNOUA1")  );
//
            ParticipatingTeamsListFragment teamsListFragment = ParticipatingTeamsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, teamsListFragment)
                    .commit();
        }

    }

    @Override
    public void onListFragmentInteraction(Team item) {
        Intent intent = new Intent();
        intent.putExtra(TEAM_NAME_EXTRA, item.getName());
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    @Override
    public ArrayList<Team> getTeamsList() {
        return viewModel.getPresenter().getResults();
    }



}
