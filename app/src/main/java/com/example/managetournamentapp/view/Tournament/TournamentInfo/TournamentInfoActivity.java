package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.managetournamentapp.R;

public class TournamentInfoActivity extends AppCompatActivity implements TournamentInfoView {
    private TournamentInfoViewModel viewModel;
    Button btnEditTournament;
    Button btnDeleteTournament;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);
    }

}
