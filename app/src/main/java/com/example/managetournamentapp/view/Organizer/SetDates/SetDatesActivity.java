package com.example.managetournamentapp.view.Organizer.SetDates;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentView;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;

import java.util.ArrayList;

public class SetDatesActivity extends AppCompatActivity implements SetDatesView {
    SetDatesViewModel viewModel;
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String BASIC_INFO_EXTRA = "basic_info_extra";
    public static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    ArrayList<String> basicInfo;
    ArrayList<EditText> editTexts = new ArrayList<>();
    String teamsNumber;
    private Button saveBtn;
    ImageButton btnHome;

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
        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());



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
        editTexts.add((EditText) findViewById(R.id.round1_start_txt));
        editTexts.add((EditText) findViewById(R.id.round1_finish_txt));
        editTexts.add((EditText) findViewById(R.id.round2_start_txt));
        editTexts.add((EditText) findViewById(R.id.round2_finish_txt));
        editTexts.add((EditText) findViewById(R.id.round3_start_txt));
        editTexts.add((EditText) findViewById(R.id.round3_finish_txt));


        if (teamsNumber.equals("16")) {
            editTexts.add((EditText) findViewById(R.id.round4_start_txt));
            editTexts.add((EditText) findViewById(R.id.round4_finish_txt));
        } else if (teamsNumber.equals("32")) {
            editTexts.add((EditText) findViewById(R.id.round4_start_txt));
            editTexts.add((EditText) findViewById(R.id.round4_finish_txt));
            editTexts.add((EditText) findViewById(R.id.round5_start_txt));
            editTexts.add((EditText) findViewById(R.id.round5_finish_txt));
        }

    }

    public void startSaveTournament(String organizerTitle) {
        Intent intent = new Intent(SetDatesActivity.this, OrganizerPageActivity.class);
        intent.putExtra(ORGANIZER_TITLE_EXTRA, organizerTitle);
        System.out.println(organizerTitle);
        startActivity(intent);
    }


    @Override
    public void backToHomePage(boolean isPlayer, String name) {
        if (isPlayer){
            Intent intent = new Intent(this, PlayerPageActivity.class);
            intent.putExtra(PLAYER_USERNAME_EXTRA,name);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent (this, OrganizerPageActivity.class);
            intent.putExtra(ORGANIZER_TITLE_EXTRA, name);
            startActivity(intent);
        }
    }

}

