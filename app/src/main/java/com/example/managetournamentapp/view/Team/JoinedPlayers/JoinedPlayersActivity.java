package com.example.managetournamentapp.view.Team.JoinedPlayers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Team.InvitePlayers.InvitePlayersActivity;
import com.example.managetournamentapp.view.Team.InvitePlayers.InvitePlayersViewModel;
import com.example.managetournamentapp.view.Team.InvitePlayers.fragment.PlayersListFragment;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class JoinedPlayersActivity extends AppCompatActivity implements PlayersListFragment.OnListFragmentInteractionListener, View.OnClickListener, JoinedPlayersView {

    JoinedPlayersViewModel viewModel;
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    public static final String PASSWORD_SHOWN_EXTRA = "password_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static boolean removeActionPopup = false;
    private static AlertDialog POPUP_ACTION;
    private static AlertDialog POPUP_DELETION;
    private static Player playerSelected;
    private boolean captain;
    private boolean player;
    private String teamName;
    private FloatingActionButton inviteNewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        teamName = this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        setContentView(R.layout.activity_joined_players);
        viewModel = new ViewModelProvider(this).get(JoinedPlayersViewModel.class);
        viewModel.getPresenter().setView(this);

        viewModel.getPresenter().findPlayers(teamName);
        inviteNewBtn = (FloatingActionButton) findViewById(R.id.invite_new_players_button);
        inviteNewBtn.setOnClickListener(this);
        viewModel.getPresenter().findAccess();          // check who is currently using the page!

        if (findViewById(R.id.fragment_container) != null) {

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null) {
                return;
            }


            PlayersListFragment playersListFragment = PlayersListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, playersListFragment)
                    .commit();
        }


    }


    @Override
    public void onListFragmentInteraction(Player item) {
        playerSelected = item;

        if (!player || item.equals((new MemoryLoggedInUser()).getUser())) {
            startPlayerInfo();
        } else {
            if (captain) {
                displayPopUpAction(R.layout.player_action_popup, "Name: " + item.getName() + "\nSurname: " + item.getSurname(), R.id.remove_player_popup, R.id.account_player_popup);
            } else {
                startPlayerInfo();
            }
        }
    }

    @Override
    public ArrayList<Player> getPlayerList() {
        return viewModel.getPresenter().getResults();
    }

    @Override
    public void onClick(View v) {

        if (removeActionPopup) {
            if (v.getId() == R.id.no_delete) {
                removeActionPopup = false;
                dismissPopUpDeletion();
                dismissPopUpAction();

            } else if (v.getId() == R.id.yes_delete) {
                viewModel.getPresenter().removePlayer(teamName, playerSelected);
                dismissPopUpDeletion();
                dismissPopUpAction();
                resetPopUps();
                restartActivity();
            }
        }

        if (v.getId() == R.id.remove_player_popup) {
            removeActionPopup = true;
            displayPopUpDeletion(R.layout.player_delete_popup, "Do you really want to delete this player?", R.id.no_delete, R.id.yes_delete);
        }

        if (v.getId() == R.id.account_player_popup) {
            startPlayerInfo();
        }

        if (v.getId() == R.id.invite_new_players_button) {
            startInvitePlayerPage();
        }

    }


    @Override
    public void changesOfAccess(boolean captain, boolean player) {
        this.captain = captain;
        this.player = player;
        if (!captain) {
            inviteNewBtn.setVisibility(View.GONE);
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

    @Override
    public void startPlayerInfo() {
        Intent intent = new Intent(this, PlayerInfoActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, playerSelected.getCredentials().getUsername());
        intent.putExtra(PASSWORD_SHOWN_EXTRA, "1");
        startActivity(intent);

    }

    @Override
    public void startInvitePlayerPage() {
        Intent intent = new Intent(this, InvitePlayersActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, teamName);
        startActivity(intent);
    }

    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2) {
        POPUP_ACTION = showPopUp(layout, msg, btn1, btn2);
        POPUP_ACTION.show();
    }

    @Override
    public void displayPopUpDeletion(int layout, String msg, int btn1, int btn2) {
        POPUP_DELETION = showPopUp(layout, msg, btn1, btn2);
        POPUP_DELETION.show();

    }

    @Override
    public void dismissPopUpAction() {
        POPUP_ACTION.dismiss();
    }

    @Override
    public void dismissPopUpDeletion() {
        POPUP_DELETION.dismiss();
    }

    @Override
    public void resetPopUps() {
        POPUP_DELETION = null;
        POPUP_ACTION = null;


    }

    @Override
    public void restartActivity() {
        this.recreate();
    }
}