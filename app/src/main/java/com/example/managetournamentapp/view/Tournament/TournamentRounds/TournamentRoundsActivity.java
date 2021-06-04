package com.example.managetournamentapp.view.Tournament.TournamentRounds;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;

public class TournamentRoundsActivity extends AppCompatActivity implements TournamentRoundsView {
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    String tournamentTitle;
    private TournamentRoundsViewModel viewModel;
    Button btnGroups;
    Button btn16;
    Button btn8;
    Button btnSemifinals;
    Button btnFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        setContentView(R.layout.activity_tournament_rounds);

        viewModel = new ViewModelProvider(this).get(TournamentRoundsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findTournamentInfo(tournamentTitle);

        btnGroups = findViewById(R.id.groups_button);
        btn16 = findViewById(R.id.round16_button);
        btn8 = findViewById(R.id.round8_button);
        btnSemifinals = findViewById(R.id.semifinals_button);
        btnFinal = findViewById(R.id.final_button);

        btnGroups.setOnClickListener(v -> viewModel.getPresenter().onGroups());
        btn16.setOnClickListener(v -> viewModel.getPresenter().on16());
        btn8.setOnClickListener(v -> viewModel.getPresenter().on8());
        btnSemifinals.setOnClickListener(v -> viewModel.getPresenter().onSemifinals());
        btnFinal.setOnClickListener(v -> viewModel.getPresenter().onFinal());

        viewModel.getPresenter().findAccess();
    }


    @Override
    public void changesOfAccess(int teamsNumber) {
        if (teamsNumber == 8){
            btn8.setVisibility(View.GONE);
            btn16.setVisibility(View.GONE);
        }else if (teamsNumber==16){
            btn16.setVisibility(View.GONE);
        }
    }

    public void showGroupRound(String tournamentTitle){

    }

    public void showRound16(String tournamentTitle){

    }

    public void showRound8(String tournamentTitle){

    }


    public void showSemifinals(String tournamentTitle){

    }


    public void showFinal(String tournamentTitle){

    }

}
