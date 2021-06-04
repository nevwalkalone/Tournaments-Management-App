package com.example.managetournamentapp.view.Team.InvitePlayers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Team.InvitePlayers.fragment.PlayersListFragment;
import com.example.managetournamentapp.view.Team.JoinedPlayers.JoinedPlayersView;

import java.util.ArrayList;

public class InvitePlayersActivity extends AppCompatActivity implements PlayersListFragment.OnListFragmentInteractionListener, View.OnClickListener, InvitePlayersView {

    public static final String PLAYER_NAME_EXTRA = "player_name_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static AlertDialog POPUP_ACTION;
    private static Player playerSelected;
    InvitePlayersViewModel viewModel;
    private String teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        teamName = this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        setContentView(R.layout.activity_invite_players);

        viewModel = new ViewModelProvider(this).get(InvitePlayersViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().setPlayerDAO((new PlayerDAOMemory()));
        viewModel.getPresenter().setTeamDAO((new TeamDAOMemory()));

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

    //TODO FIXING
    @Override
    public void onListFragmentInteraction(Player item) {
        playerSelected = item;
        POPUP_ACTION = showPopUp(R.layout.invite_player_popup, "Name: " + item.getName() + "\nSurname: " + item.getSurname(), R.id.invite_player_popup, R.id.account_player_popup);
        POPUP_ACTION.show();
    }

    @Override
    public ArrayList<Player> getPlayerList() {
        return viewModel.getPresenter().getResults();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.account_player_popup) {
            Intent intent = new Intent(this, PlayerInfoActivity.class);
            intent.putExtra(PLAYER_USERNAME_EXTRA, playerSelected.getCredentials().getUsername());
            startActivity(intent);
        }

    }


    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);
        Button firstButton = (Button) customLayout.findViewById(btn1);
        Button secondButton = (Button) customLayout.findViewById(btn2);

        textMsg.setText(msg);

        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        return dialog;
    }
}

