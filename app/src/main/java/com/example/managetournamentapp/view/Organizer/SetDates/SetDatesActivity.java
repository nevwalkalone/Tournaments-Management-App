package com.example.managetournamentapp.view.Organizer.SetDates;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentView;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;

import java.util.ArrayList;

public class SetDatesActivity extends AppCompatActivity implements SetDatesView {
    SetDatesViewModel viewModel;
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String BASIC_INFO_EXTRA = "basic_info_extra";
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
        viewModel.presenter.findBasicInfo(basicInfo);

        saveBtn = (Button) findViewById(R.id.save_tournament);
        saveBtn.setOnClickListener(v -> viewModel.getPresenter().onSaveTournament());


    }


    public ArrayList<String> getDates() {
        ArrayList<String> dates = new ArrayList<>();
        int len;
        if (teamsNumber.equals("8"))
            len = 6;
        else if (teamsNumber.equals("16"))
            len = 8;
        else
            len = 10;

        for (int i = 0; i < len; i++) {
            Log.wtf("getting edittext", String.valueOf(i));
            if (editTexts.get(i).getText().toString().isEmpty())
                continue;
            dates.add(editTexts.get(i).getText().toString());
        }
        return dates;
    }

    @Override
    public void showPopUp(SetDatesView view, String msg) {
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

    public void setupLayout(String teamsNumber) {
        editTexts.clear();
        if (teamsNumber.equals("8")) {
            setContentView(R.layout.activity_set_dates_8);
        } else if (teamsNumber.equals("16")) {
            setContentView(R.layout.activity_set_dates_16);
        } else if (teamsNumber.equals("32")) {
            setContentView(R.layout.activity_set_dates_32);
        }

        Log.wtf("testtt", ((EditText) findViewById(R.id.round1_start_txt)).getText().toString());
        editTexts.add((EditText) findViewById(R.id.round1_start_txt));
        editTexts.add((EditText) findViewById(R.id.round1_finish_txt));
        editTexts.add((EditText) findViewById(R.id.round2_start_txt));
        editTexts.add((EditText) findViewById(R.id.round2_finish_txt));
        editTexts.add((EditText) findViewById(R.id.round3_start_txt));
        editTexts.add((EditText) findViewById(R.id.round3_finish_txt));


        if (teamsNumber.equals("16")) {
            editTexts.add((EditText) findViewById(R.id.round4_start_txt));
            editTexts.add((EditText) findViewById(R.id.round4_finish_txt));
            Log.wtf("setupp", "in 16");

        } else if (teamsNumber.equals("32")) {
            editTexts.add((EditText) findViewById(R.id.round4_start_txt));
            editTexts.add((EditText) findViewById(R.id.round4_finish_txt));
            editTexts.add((EditText) findViewById(R.id.round5_start_txt));
            editTexts.add((EditText) findViewById(R.id.round5_finish_txt));
        }

    }

    public void startSaveTournament(String tournamentName) {
        Intent intent = new Intent(SetDatesActivity.this, TournamentPageActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, tournamentName);
        startActivity(intent);
    }


}

