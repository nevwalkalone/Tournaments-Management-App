package com.example.managetournamentapp.view.Player.PlayerPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsViewModel;
import com.example.managetournamentapp.view.Player.PlayerInfo.PlayerInfoActivity;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.ParticipatingTeamsListFragment;

public class PlayerPageActivity extends AppCompatActivity implements  PlayerPageView{
    private PlayerPageViewModel viewModel;
    TextView txtPlayerName;
    Button btnPlayerAccount;
    Button btnPlayerTeams;
    Button btnPlayerInvites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

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
