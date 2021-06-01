package com.example.managetournamentapp.view.Player.JoinedTeams;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.ParticipatingTeamsListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class JoinedTeamsActivity extends AppCompatActivity implements ParticipatingTeamsListFragment.OnListFragmentInteractionListener {
//todo add to fragment

    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    JoinedTeamsViewModel viewModel;
    private FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joined_teams);
        Intent intent = getIntent();

//
//        Log.d("BookSearchActivity", "Search criteria: " + titleCriterion
//                + " " + authorCriterion);

        viewModel = new ViewModelProvider(this).get(JoinedTeamsViewModel.class);
        addBtn = findViewById(R.id.create_team_button);

        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findJoinedTeams( (new MemoryLoggedInUser()).getUser()  );

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

