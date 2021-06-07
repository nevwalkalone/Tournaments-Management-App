package com.example.managetournamentapp.view.Player.PlayerPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Player.ReceivedInvites.ReceivedInvitesActivity;
import com.example.managetournamentapp.view.User.Login.LoginActivity;

public class PlayerPageActivity extends AppCompatActivity implements PlayerPageView {

    //public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private boolean sameAsLogged = true;
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private PlayerPageViewModel viewModel;
    private static AlertDialog POPUP_ACTION;
    TextView txtPlayerName;
    Button btnPlayerAccount;
    Button btnPlayerTeams;
    Button btnPlayerInvites;
    Button btnLogOut;
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
        btnLogOut = findViewById(R.id.log_out_button);

        txtPlayerName.setText(viewModel.getPresenter().getPlayerName());
        btnPlayerAccount.setOnClickListener(v -> viewModel.getPresenter().onPlayerAccount());
        btnPlayerTeams.setOnClickListener(v -> viewModel.getPresenter().onPlayerTeams());
        btnPlayerInvites.setOnClickListener(v -> viewModel.getPresenter().onPlayerInvites());
        btnLogOut.setOnClickListener(v->viewModel.getPresenter().onLogOut());
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

    public void logOut(){
        Toast.makeText(this,
                "LOGGED OUT",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(PlayerPageActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2) {
        POPUP_ACTION = showPopUp(layout, msg, btn1, btn2);
        POPUP_ACTION.show();
    }

    @Override
    public void dismissPopUpAction() {
        POPUP_ACTION.dismiss();
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

        firstButton.setOnClickListener(v->viewModel.getPresenter().onNoLogOut());
        secondButton.setOnClickListener(v->viewModel.getPresenter().onYesLogOut());

        return dialog;
    }

    @Override
    public void logOutConfirmation() {
        POPUP_ACTION = showPopUp(R.layout.tournament_delete_popup, "Do you really want to log out?", R.id.no_delete, R.id.yes_delete);

        POPUP_ACTION.show();
    }

    @Override
    public void noLogOut() {
        POPUP_ACTION.dismiss();
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
