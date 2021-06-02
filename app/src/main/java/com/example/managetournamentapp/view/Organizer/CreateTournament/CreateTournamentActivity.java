package com.example.managetournamentapp.view.Organizer.CreateTournament;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.managetournamentapp.R;


import java.util.ArrayList;

public class CreateTournamentActivity extends AppCompatActivity {
    private CreateTournamentView viewModel;
    public static final String TOURNAMENT_NAME_EXTRA = "tournament_name_extra";
    private Button saveBtn;
    private Spinner spinner;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_create_tournament);
   }

}
