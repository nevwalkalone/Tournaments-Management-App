package com.example.managetournamentapp.view.Player.PlayerPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;

public class PlayerPageActivity extends AppCompatActivity implements PlayerPageView{

    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra" ;
    private PlayerPageViewModel viewModel;
    TextView txtPlayerName;
    Button btnPlayerAccount;
    Button btnPlayerTeams;
    Button btnPlayerInvites;
    private String playerUsername;
    private static boolean init = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (init){
            new MemoryInitializer().prepareData();
            init = false;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);
        playerUsername =  this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(PlayerPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findPlayerInfo(playerUsername);
        viewModel.getPresenter().findAccess();

        txtPlayerName = findViewById(R.id.text_player_name);
        btnPlayerAccount = findViewById(R.id.player_account_button);
        btnPlayerTeams = findViewById(R.id.player_teams_button);
        btnPlayerInvites = findViewById(R.id.player_invites_button);

        txtPlayerName.setText( viewModel.getPresenter().getPlayerName() );
        btnPlayerAccount.setOnClickListener(v -> viewModel.getPresenter().onPlayerAccount());
        btnPlayerTeams.setOnClickListener(v -> viewModel.getPresenter().onPlayerTeams());
        btnPlayerInvites.setOnClickListener(v -> viewModel.getPresenter().onPlayerInvites());

    }

    public void toPlayerAccount(){
        Intent intent = new Intent(PlayerPageActivity.this, PlayerInfoActivity.class);
        startActivity(intent);
    }

    public void toPlayerTeams(){
        Intent intent = new Intent(PlayerPageActivity.this, JoinedTeamsActivity.class);
        startActivity(intent);
    }

    public void toPlayerInvites(){
      // Intent intent = new Intent(PlayerPageActivity.this, PlayerInvitedActivity.class);
     //  startActivity(intent);
    }

    public void changesOfAccess(){

        btnPlayerInvites.setVisibility(View.GONE);
    }



}
