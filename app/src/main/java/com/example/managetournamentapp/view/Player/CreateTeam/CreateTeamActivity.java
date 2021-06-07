package com.example.managetournamentapp.view.Player.CreateTeam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.TournamentType;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Player.JoinedTeams.JoinedTeamsActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerView;

import java.util.ArrayList;

public class CreateTeamActivity extends AppCompatActivity implements CreateTeamView {

    CreateTeamViewModel viewModel;
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private Button saveBtn;
    private Spinner spinner;
    String teamName;
    ImageButton btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        teamName = this.getIntent().getStringExtra(TEAM_NAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(CreateTeamViewModel.class);
        viewModel.getPresenter().setView(this);

        spinner = findViewById(R.id.sport_spinner);
        setSpinnerList(viewModel.getPresenter().getSportTypes());

        viewModel.getPresenter().showPreviousInfo(teamName);

        saveBtn = findViewById(R.id.saveTeambtn);
        btnHome = findViewById(R.id.imageButton);
        saveBtn.setOnClickListener(v -> viewModel.getPresenter().onSaveTeam());
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());

    }

    @Override
    public void startSaveTeam(String userName) {
        Intent intent = new Intent(CreateTeamActivity.this, JoinedTeamsActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, userName);
        startActivity(intent);
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
        return spinner.getSelectedItemPosition();
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

    public void setSpinnerList(ArrayList<String> list) {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void showPopUp(CreateTeamView view, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();
        Button OKbtn = (Button) customLayout.findViewById(R.id.OK_popup);
        TextView errorMsg = (TextView) customLayout.findViewById(R.id.error_messsage);      // display message we want.
        errorMsg.setText(msg);
        OKbtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void backToHomePage( String name) {
        Intent intent = new Intent(this, PlayerPageActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA,name);
        startActivity(intent);
    }

}
