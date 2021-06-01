package com.example.managetournamentapp.view.Player.PlayerPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private PlayerPageViewModel viewModel;
    TextView txtPlayerName;
    Button btnPlayerAccount;
    Button btnPlayerTeams;
    Button btnPlayerInvites;
    private static boolean init = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        if (init){
            new MemoryInitializer().prepareData();
            init = false;
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);



        viewModel = new ViewModelProvider(this).get(PlayerPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtPlayerName = findViewById(R.id.text_player_name);
        btnPlayerAccount = findViewById(R.id.player_account_button);
        btnPlayerTeams = findViewById(R.id.player_teams_button);
        btnPlayerInvites = findViewById(R.id.player_invites_button);

        txtPlayerName.setText( ((Player) (new MemoryLoggedInUser()).getUser()).getName() );
        btnPlayerAccount.setOnClickListener(v -> viewModel.getPresenter().onPlayerAccount());
        btnPlayerTeams.setOnClickListener(v -> viewModel.getPresenter().onPlayerTeams());
        btnPlayerInvites.setOnClickListener(v -> viewModel.getPresenter().onPlayerInvites());

        Log.wtf("pl page" , ((Player) (new MemoryLoggedInUser()).getUser()).getTeamsJoined().toString() );
        Log.wtf("pl page" , (new TeamDAOMemory()).findAll().toString() );


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



}
