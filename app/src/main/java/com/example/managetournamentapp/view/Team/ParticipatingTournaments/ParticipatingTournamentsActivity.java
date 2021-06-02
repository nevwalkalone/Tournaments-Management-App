package com.example.managetournamentapp.view.Team.ParticipatingTournaments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.CreatedTournamentsActivity;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Team.AddParticipation.AddParticipationActivity;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ParticipatingTournamentsActivity extends AppCompatActivity implements ParticipatingTournamentsView, TournamentListFragment.OnListFragmentInteractionListener {
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    String teamName;
    ParticipatingTournamentsViewModel viewModel;
    private FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        teamName =  this.getIntent().getStringExtra(TEAM_NAME_EXTRA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participating_tournaments);
        viewModel = new ViewModelProvider(this).get(ParticipatingTournamentsViewModel.class);
        viewModel.getPresenter().setView(this);

        addBtn = findViewById(R.id.add_participation_button);
        addBtn.setOnClickListener(v -> viewModel.getPresenter().onAddParticipation());

        if (findViewById(R.id.fragment_container) != null){


            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findParticipatingTournaments(teamName);

            TournamentListFragment tournamentListFragment = TournamentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, tournamentListFragment)
                    .commit();
        }
    }

    @Override
    public void onListFragmentInteraction(Tournament item) {
        Intent intent = new Intent();
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, item.getTitle());
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    @Override
    public ArrayList<Tournament> getTournamentList() {
        return viewModel.getPresenter().getResults();
    }

    @Override
    public void startAddParticipation(){
        Intent intent = new Intent(ParticipatingTournamentsActivity.this, AddParticipationActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, teamName);
        startActivity(intent);
    }


}