package com.example.managetournamentapp.view.Team.JoinedPlayers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.view.Team.InvitePlayers.InvitePlayersActivity;
import com.example.managetournamentapp.view.Team.InvitePlayers.InvitePlayersViewModel;
import com.example.managetournamentapp.view.Team.InvitePlayers.fragment.PlayersListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class JoinedPlayersActivity extends AppCompatActivity implements PlayersListFragment.OnListFragmentInteractionListener, View.OnClickListener, JoinedPlayersView {

    JoinedPlayersViewModel viewModel;
    public static final String PLAYER_NAME_EXTRA = "player_name_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    String teamName;
    private FloatingActionButton inviteNewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        new MemoryInitializer().prepareData();
        super.onCreate(savedInstanceState);
        teamName = this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        setContentView(R.layout.activity_joined_players);

        inviteNewBtn = (FloatingActionButton) findViewById(R.id.invite_new_players_button);
        inviteNewBtn.setOnClickListener(this);

        viewModel = new ViewModelProvider(this).get(JoinedPlayersViewModel.class);

        if (findViewById(R.id.fragment_container) != null) {

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null) {
                return;
            }

            viewModel.getPresenter().findPlayers(teamName);

            PlayersListFragment playersListFragment = PlayersListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, playersListFragment)
                    .commit();
        }

    }

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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.invite_new_players_button) {
            Intent intent = new Intent(this, InvitePlayersActivity.class);
            startActivity(intent);
        }

    }


    @Override
    public void changesOfAccess() {

    }
}