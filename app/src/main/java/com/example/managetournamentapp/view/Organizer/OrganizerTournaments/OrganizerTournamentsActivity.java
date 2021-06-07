package com.example.managetournamentapp.view.Organizer.OrganizerTournaments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class OrganizerTournamentsActivity extends AppCompatActivity implements OrganizerTournamentsView,TournamentListFragment.OnListFragmentInteractionListener {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    OrganizerTournamentsViewModel viewModel;
    private FloatingActionButton addBtn;
    ImageButton btnHome;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_tournaments);
        String orgTitle = this.getIntent().getStringExtra(ORGANIZER_TITLE_EXTRA);

        viewModel = new ViewModelProvider(this).get(OrganizerTournamentsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findCreatedTournaments( orgTitle );

        addBtn = findViewById(R.id.create_tournament_button);
        addBtn.setOnClickListener(v -> viewModel.getPresenter().onAddTournament());
        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v->viewModel.getPresenter().onHomePage());

        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

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

    @Override
    public void backToHomePage(String title){
        Intent intent = new Intent (this, OrganizerPageActivity.class);
        intent.putExtra(ORGANIZER_TITLE_EXTRA, title);
        startActivity(intent);
    }
}