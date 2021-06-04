package com.example.managetournamentapp.view.Team.InvitePlayers;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.view.Team.InvitePlayers.fragment.PlayersListFragment;

import java.util.ArrayList;

public class InvitePlayersActivity extends AppCompatActivity implements PlayersListFragment.OnListFragmentInteractionListener {

    public static final String PLAYER_NAME_EXTRA = "player_name_extra";
    InvitePlayersViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_players);

        Intent intent = getIntent();

        viewModel = new ViewModelProvider(this).get(InvitePlayersViewModel.class);

        if (findViewById(R.id.fragment_container) != null){

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findPlayers();

            PlayersListFragment playersListFragment = PlayersListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, playersListFragment)
                    .commit();
        }

    }

    //TODO FIXING
    @Override
    public void onListFragmentInteraction(Player item) {
        Intent intent = new Intent();
        intent.putExtra(PLAYER_NAME_EXTRA, item.getName());
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    @Override
    public ArrayList<Player> getPlayerList() {
        return viewModel.getPresenter().getResults();
    }

}

