package com.example.managetournamentapp.view.Tournament.RoundGames;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.view.Tournament.RoundGames.fragment.GamesListFragment;

import java.util.ArrayList;

public class RoundGamesActivity extends AppCompatActivity implements GamesListFragment.OnListFragmentInteractionListener,  RoundGamesView {

    public static final String  TOURNAMENT_TITLE_EXTRA= "tournament_title_extra";
    private static final String ROUND_TEAMS_EXTRA = "round_teams_extra" ;
    private static final String SPECIFIC_GROUP_EXTRA = "specific_group_extra" ;
    RoundGamesViewModel viewModel;
    private String tournamentTitle;
    private int roundTeamsNumber;
    private int specificGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_games);
        viewModel = new ViewModelProvider(this).get(RoundGamesViewModel.class);
        viewModel.getPresenter().setView(this);

        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        roundTeamsNumber = Integer.parseInt( this.getIntent().getStringExtra(ROUND_TEAMS_EXTRA) );
        specificGroup = Integer.parseInt( this.getIntent().getStringExtra(SPECIFIC_GROUP_EXTRA) );

        if (findViewById(R.id.fragment_container) != null) {

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null) {
                return;
            }

            viewModel.getPresenter().findGames(tournamentTitle, roundTeamsNumber, specificGroup);

            GamesListFragment gamesListFragment = GamesListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, gamesListFragment)
                    .commit();
        }
    }


    @Override
    public void changesOfAccess() {

    }

    @Override
    public void onListFragmentInteraction(Game item) {
        Toast.makeText(this,
                "GAME SELECTED",
                Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    public ArrayList<Game> getGamesList() {
        return viewModel.getPresenter().getResults();
    }


}
