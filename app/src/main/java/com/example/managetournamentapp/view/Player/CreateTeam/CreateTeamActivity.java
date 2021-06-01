package com.example.managetournamentapp.view.Player.CreateTeam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.TournamentType;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;

import java.util.ArrayList;

public class CreateTeamActivity extends AppCompatActivity implements CreateTeamView {

    CreateTeamViewModel viewModel;
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private Button saveBtn;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        viewModel = new ViewModelProvider(this).get(CreateTeamViewModel.class);
        viewModel.getPresenter().setView(this);

        spinner =  findViewById(R.id.sport_spinner);
        setSpinnerList( viewModel.getPresenter().getSportTypes() );

        viewModel.getPresenter().showPreviousInfo();

        saveBtn = findViewById(R.id.saveTeambtn);
        saveBtn.setOnClickListener(v -> viewModel.getPresenter().onSaveTeam());

        saveBtn.setOnClickListener(v -> {
            if (viewModel.getPresenter().onSaveTeam()){
                Log.wtf("creat page" , ((Player) (new MemoryLoggedInUser()).getUser()).getTeamsJoined().toString() );
                Log.wtf("creat page" , (new TeamDAOMemory()).findAll().toString() );
                Intent intent = new Intent(CreateTeamActivity.this, TeamPageActivity.class);
                intent.putExtra(TEAM_NAME_EXTRA, getTeamName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void startSaveTeam() {

    }

    @Override
    public String getTeamName() {
        return ((EditText) findViewById(R.id.team_name)).getText().toString();
    }

    @Override
    public String getTeamColors() {
        return ((EditText) findViewById(R.id.team_colors)).getText().toString();
    }

    @Override
    public int getSportType() {
        return spinner.getSelectedItemPosition()+1;
    }

    @Override
    public String getConnectedTeamName() {
        if (this.getIntent().getStringExtra(TEAM_NAME_EXTRA)== null)  {
            Log.wtf("got" ,"nulli");
            return null;
        } else {
            Log.wtf("got" ,this.getIntent().getStringExtra(TEAM_NAME_EXTRA) );
            return this.getIntent().getStringExtra(TEAM_NAME_EXTRA);
        }
    }

    @Override
    public void setTeamName(String name) {
        ((EditText) findViewById(R.id.team_name)).setText(name);
    }

    @Override
    public void setTeamColors(String colors) {
        ((EditText) findViewById(R.id.team_colors)).setText(colors);

    }

    @Override
    public void setSportType(int position) {
        spinner.setSelection(position);
    }

    @Override
    public void lockSportType() {
        spinner.setEnabled(false);
    }

    public void setSpinnerList(ArrayList<String> list){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
