package com.example.managetournamentapp.view.Organizer.SetDates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;

import java.util.ArrayList;

public class SetDatesActivity extends AppCompatActivity implements SetDatesView {
    SetDatesViewModel viewModel;
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String BASIC_INFO_EXTRA = "basic_info_extra" ;
    ArrayList<String> basicInfo;
    ArrayList<EditText> editTexts = new ArrayList<>();
    String teamsNumber;
    private Button saveBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(SetDatesViewModel.class);
        viewModel.getPresenter().setView(this);

        basicInfo = (ArrayList<String>) this.getIntent().getSerializableExtra(BASIC_INFO_EXTRA);
        teamsNumber = basicInfo.get(5);
        setupLayout(teamsNumber);



        saveBtn = (Button) findViewById(R.id.save_tournament);
        saveBtn.setOnClickListener(v -> viewModel.getPresenter().onSaveTournament());

    }


    public ArrayList<String> getDates() {
        ArrayList<String> dates = new ArrayList<>();
        for (EditText e : editTexts)
            dates.add(e.getText().toString());
        return dates;
    }

    public void setupLayout(String teamsNumber){
        editTexts.add( (EditText) findViewById(R.id.round1_start_txt) );
        editTexts.add( (EditText) findViewById(R.id.round1_finish_txt) );
        editTexts.add( (EditText) findViewById(R.id.round2_start_txt) );
        editTexts.add( (EditText) findViewById(R.id.round2_finish_txt) );
        editTexts.add( (EditText) findViewById(R.id.round3_start_txt) );
        editTexts.add( (EditText) findViewById(R.id.round3_finish_txt) );
        setContentView(R.layout.activity_set_dates_8);

        if (teamsNumber.equals("16")){
            editTexts.add( (EditText) findViewById(R.id.round4_start_txt) );
            editTexts.add( (EditText) findViewById(R.id.round4_finish_txt) );
            setContentView(R.layout.activity_set_dates_16);
        }else if(teamsNumber.equals("32")) {
            editTexts.add( (EditText) findViewById(R.id.round4_start_txt) );
            editTexts.add( (EditText) findViewById(R.id.round4_finish_txt) );
            editTexts.add( (EditText) findViewById(R.id.round5_start_txt) );
            editTexts.add( (EditText) findViewById(R.id.round5_finish_txt) );
            setContentView(R.layout.activity_set_dates_32);
        }

    }

    public void startSaveTournament(String tournamentName){
        Intent intent = new Intent(SetDatesActivity.this, TournamentPageActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, tournamentName);
        startActivity(intent);
    }


}

