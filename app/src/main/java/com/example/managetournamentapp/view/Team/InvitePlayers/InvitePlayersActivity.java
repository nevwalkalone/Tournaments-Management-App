package com.example.managetournamentapp.view.Team.InvitePlayers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Team.InvitePlayers.fragment.PlayersListFragment;


import java.util.ArrayList;

public class InvitePlayersActivity extends AppCompatActivity implements PlayersListFragment.OnListFragmentInteractionListener, View.OnClickListener, InvitePlayersView {

    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static AlertDialog POPUP_ACTION;
    private static Player playerSelected;
    InvitePlayersViewModel viewModel;
    private String teamName;
    ImageButton btnHome;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        teamName = this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        setContentView(R.layout.activity_invite_players);

        viewModel = new ViewModelProvider(this).get(InvitePlayersViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findPlayers(teamName);

        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());

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
        viewModel.getPresenter().displayPopAction(R.layout.invite_player_popup, "Name: " + item.getName() + "\nSurname: " + item.getSurname(), R.id.invite_player_popup, R.id.account_player_popup, false);

    }

    @Override
    public ArrayList<Player> getPlayerList() {
        return viewModel.getPresenter().getResults();
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String newButton = b.getText().toString();

        if ("OK".equals(newButton)) {
            viewModel.getPresenter().closePopAction();
            viewModel.getPresenter().restartActivity();
        } else if (v.getId() == R.id.invite_player_popup) {
            viewModel.getPresenter().inviteNewPlayer(teamName, playerSelected);
            viewModel.getPresenter().closePopAction();
            viewModel.getPresenter().displayPopAction(R.layout.invite_player_popup, "Succesfully invited " + playerSelected.getName() + " " + playerSelected.getSurname() + "!", R.id.invite_player_popup, R.id.account_player_popup, true);

        } else if (v.getId() == R.id.account_player_popup) {
            viewModel.getPresenter().onPlayerAccountSelected(playerSelected);
        }

    }

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, boolean changePopup) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);
        Button firstButton = (Button) customLayout.findViewById(btn1);
        Button secondButton = (Button) customLayout.findViewById(btn2);

        textMsg.setText(msg);

        if (changePopup) {
            TextView tempMsg = customLayout.findViewById(btn1);
            tempMsg.setText("OK");
            secondButton.setVisibility(View.GONE);
        }
        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        return dialog;
    }

    @Override
    public void startPlayerPage(Player player) {
        Intent intent = new Intent(this, PlayerInfoActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, player.getCredentials().getUsername());
        startActivity(intent);
    }


    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2, boolean invited) {
        POPUP_ACTION = showPopUp(layout, msg, btn1, btn2, invited);
        POPUP_ACTION.show();
    }


    @Override
    public void dismissPopUpAction() {
        POPUP_ACTION.dismiss();
    }


    @Override
    public void resetPopUps() {
        POPUP_ACTION = null;
    }

    @Override
    public void restartActivity() {
        this.recreate();
    }


    @Override
    public void backToHomePage( String name) {
        Intent intent = new Intent(this, PlayerPageActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA,name);
        startActivity(intent);
    }

}



