package com.example.managetournamentapp.view.Organizer.CreatedTournaments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.fragment.TournamentListFragment;
import java.util.ArrayList;

public class CreatedTournamentsActivity extends AppCompatActivity implements TournamentListFragment.OnListFragmentInteractionListener {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    CreatedTournamentsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_tournaments);

        Intent intent = getIntent();

//
//        Log.d("BookSearchActivity", "Search criteria: " + titleCriterion
//                + " " + authorCriterion);

        viewModel = new ViewModelProvider(this).get(CreatedTournamentsViewModel.class);

        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findCreatedTournaments( (new OrganizerDAOMemory()).find("ESKA")  );

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



}