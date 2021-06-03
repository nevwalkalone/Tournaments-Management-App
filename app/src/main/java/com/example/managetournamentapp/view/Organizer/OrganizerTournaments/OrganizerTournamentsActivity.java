package com.example.managetournamentapp.view.Organizer.OrganizerTournaments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class OrganizerTournamentsActivity extends AppCompatActivity implements OrganizerTournamentsView,TournamentListFragment.OnListFragmentInteractionListener {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    OrganizerTournamentsViewModel viewModel;
    private FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_tournaments);
        viewModel = new ViewModelProvider(this).get(OrganizerTournamentsViewModel.class);
        viewModel.getPresenter().setView(this);

        addBtn = findViewById(R.id.create_tournament_button);
        addBtn.setOnClickListener(v -> viewModel.getPresenter().onAddTournament());

        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findCreatedTournaments( "ESKA"  );

            TournamentListFragment tournamentListFragment = TournamentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, tournamentListFragment)
                    .commit();
        }

    }

    @Override
    public void onListFragmentInteraction(Tournament item) {
        Intent intent = new Intent(OrganizerTournamentsActivity.this, TournamentPageActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, item.getTitle());
        startActivity(intent);
    }

    @Override
    public ArrayList<Tournament> getTournamentList() {
        return viewModel.getPresenter().getResults();
    }


    @Override
    public void startCreateTournament() {
        Intent intent = new Intent(OrganizerTournamentsActivity.this, CreateTournamentActivity.class);
        startActivity(intent);
    }
}