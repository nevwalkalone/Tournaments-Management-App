package com.example.managetournamentapp.view.Player.PlayerPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Player.ReceivedInvites.ReceivedInvitesActivity;

public class PlayerPageActivity extends AppCompatActivity implements PlayerPageView {

    //public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private boolean sameAsLogged = true;
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private PlayerPageViewModel viewModel;
    TextView txtPlayerName;
    Button btnPlayerAccount;
    Button btnPlayerTeams;
    Button btnPlayerInvites;
    private String playerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);
        playerUsername = this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(PlayerPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findPlayerInfo(playerUsername);


        txtPlayerName = findViewById(R.id.text_player_name);
        btnPlayerAccount = findViewById(R.id.player_account_button);
        btnPlayerTeams = findViewById(R.id.player_teams_button);
        btnPlayerInvites = findViewById(R.id.player_invites_button);

        txtPlayerName.setText(viewModel.getPresenter().getPlayerName());
        btnPlayerAccount.setOnClickListener(v -> viewModel.getPresenter().onPlayerAccount());
        btnPlayerTeams.setOnClickListener(v -> viewModel.getPresenter().onPlayerTeams());
        btnPlayerInvites.setOnClickListener(v -> viewModel.getPresenter().onPlayerInvites());

        viewModel.getPresenter().findAccess(playerUsername);

    }

    public void toPlayerInfo(String playerUsername) {
        Intent intent = new Intent(PlayerPageActivity.this, PlayerInfoActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, playerUsername);
        startActivity(intent);
    }

    public void toPlayerTeams(String playerUsername) {
        Intent intent = new Intent(PlayerPageActivity.this, JoinedTeamsActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, playerUsername);
        startActivity(intent);
    }


    public void toPlayerInvites(String playerUsername) {
        Intent intent = new Intent(PlayerPageActivity.this, ReceivedInvitesActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, playerUsername);
        startActivity(intent);
    }

    public void changesOfAccess() {
        sameAsLogged = false;
        btnPlayerInvites.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if(sameAsLogged){
            AlertDialog.Builder builder = new AlertDialog.Builder(PlayerPageActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
