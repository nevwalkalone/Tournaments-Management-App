package com.example.managetournamentapp.view.Organizer.CreateTournament;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.SetDates.SetDatesActivity;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;
import java.util.ArrayList;


public class CreateTournamentActivity extends AppCompatActivity implements CreateTournamentView {
    private static final String BASIC_INFO_EXTRA = "basic_info_extra" ;
    private CreateTournamentViewModel viewModel;
    public static final String TOURNAMENT_NAME_EXTRA = "tournament_name_extra";
    private Button saveBtn;
    String tournamentTitle;
    private Spinner sportTypeSpinner;
    private Spinner ageDivisionSpinner;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_create_tournament);

       tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_NAME_EXTRA);
       viewModel = new ViewModelProvider(this).get(CreateTournamentViewModel.class);
       viewModel.getPresenter().setView(this);

       sportTypeSpinner =  findViewById(R.id.sport_spinner);
       setSportTypeSpinner( viewModel.getPresenter().getSportTypes() );

       ageDivisionSpinner =  findViewById(R.id.age_spinner);
       setAgeDivisionSpinner( viewModel.getPresenter().getAgeDivisions() );

       viewModel.getPresenter().showPreviousInfo(tournamentTitle);

       saveBtn = findViewById(R.id.saveTeambtn);
       saveBtn.setOnClickListener(v -> viewModel.getPresenter().onSaveTournament());
   }

    @Override
    public void startSaveTournament(String tournamentTitle) {
        Intent intent = new Intent(CreateTournamentActivity.this, TournamentPageActivity.class);
        intent.putExtra(TOURNAMENT_NAME_EXTRA, tournamentTitle);
        startActivity(intent);
    }

    @Override
    public void startSetDates(ArrayList<String> basicInfo){
        Intent intent = new Intent(CreateTournamentActivity.this, SetDatesActivity.class);
        intent.putExtra(BASIC_INFO_EXTRA , basicInfo);
        startActivity(intent);
    }

    @Override
    public String getTournamentTitle() {
        return ((EditText) findViewById(R.id.tournament_title)).getText().toString();

    }

    @Override
    public String getLocation() {
        return ((EditText) findViewById(R.id.tournament_location)).getText().toString();
    }

    @Override
    public String getStartDate() {
        return ((EditText) findViewById(R.id.tournament_start_date)).getText().toString();

    }

    @Override
    public String getFinishDate() {
        return ((EditText) findViewById(R.id.tournament_finish_date)).getText().toString();

    }

    @Override
    public int getAgeDivision() {
        return ageDivisionSpinner.getSelectedItemPosition();
    }

    @Override
    public String getTeamsNumber() {
        return ((EditText) findViewById(R.id.tournament_teams_number)).getText().toString() ;

    }

    @Override
    public int getSportType() {
        return sportTypeSpinner.getSelectedItemPosition();
    }

    @Override
    public void setTournamentTitle(String title) {
        ((EditText) findViewById(R.id.tournament_title)).setText(title);

    }

    @Override
    public void setLocation(String location) {
        ((EditText) findViewById(R.id.tournament_location)).setText(location);
    }

    @Override
    public void setStartDate(String date) {
        ((EditText) findViewById(R.id.tournament_start_date)).setText(date);
    }

    @Override
    public void setFinishDate(String date) {
        ((EditText) findViewById(R.id.tournament_finish_date)).setText(date);
    }


    @Override
    public void setAgeDivision(int position) {
       ageDivisionSpinner.setSelection(position);
    }

    @Override
    public void setTeamsNumber(int teamsNumber) {
        ((EditText) findViewById(R.id.tournament_teams_number)).setText(teamsNumber);
    }

    @Override
    public void setSportType(int position) {
        sportTypeSpinner.setSelection(position);

    }

    @Override
    public void lockSportType() {

    }


    public void setSportTypeSpinner(ArrayList<String> list){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sportTypeSpinner.setAdapter(adapter);
    }


    public void setAgeDivisionSpinner(ArrayList<String> list){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageDivisionSpinner.setAdapter(adapter);
    }
}
