package com.example.managetournamentapp.view.Team.AddParticipation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Team.ParticipatingTournaments.ParticipatingTournamentsActivity;

import java.util.ArrayList;

public class AddParticipationActivity  extends AppCompatActivity implements  AddParticipationView, TournamentListFragment.OnListFragmentInteractionListener{
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    String teamName;
    AddParticipationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        teamName =  this.getIntent().getStringExtra(TEAM_NAME_EXTRA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participation);
        viewModel = new ViewModelProvider(this).get(AddParticipationViewModel.class);

        if (findViewById(R.id.fragment_container) != null){

            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findTournaments( teamName  );

            TournamentListFragment tournamentListFragment = TournamentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, tournamentListFragment)
                    .commit();
        }
    }


    @Override
    public void onListFragmentInteraction(Tournament item) {
        viewModel.getPresenter().onAddParticipation(item);
        Intent intent = new Intent(AddParticipationActivity.this, ParticipatingTournamentsActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, teamName);
        startActivity(intent);
    }

    @Override
    public ArrayList<Tournament> getTournamentList() {
        return viewModel.getPresenter().getResults();
    }


}
