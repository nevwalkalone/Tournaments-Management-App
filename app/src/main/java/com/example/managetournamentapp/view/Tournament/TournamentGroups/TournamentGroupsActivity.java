package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;

import java.util.ArrayList;


public class TournamentGroupsActivity extends AppCompatActivity implements TournamentGroupsView {
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String ROUND_TEAMS_EXTRA = "round_teams_extra" ;
    private TournamentGroupsViewModel viewModel;
    String tournamentTitle;
    ArrayList<Button> groupButtons = new ArrayList<>();
    Button btnGroupA;
    Button btnGroupB;
    Button btnGroupC;
    Button btnGroupD;
    Button btnGroupE;
    Button btnGroupF;
    Button btnGroupG;
    Button btnGroupH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        setContentView(R.layout.activity_tournament_groups);

        viewModel = new ViewModelProvider(this).get(TournamentGroupsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findTournamentInfo(tournamentTitle);

        groupButtons.add( findViewById(R.id.group_A_button) );
        groupButtons.add( findViewById(R.id.group_B_button) );
        groupButtons.add( findViewById(R.id.group_C_button) );
        groupButtons.add( findViewById(R.id.group_D_button) );
        groupButtons.add( findViewById(R.id.group_E_button) );
        groupButtons.add( findViewById(R.id.group_F_button) );
        groupButtons.add( findViewById(R.id.group_G_button) );
        groupButtons.add( findViewById(R.id.group_H_button) );

        for (int i=0;i<groupButtons.size();i++) {
            int finalI = i;
            groupButtons.get(i).setOnClickListener(v -> viewModel.getPresenter().onGroup(finalI) );
        }

        viewModel.getPresenter().findAccess();
    }


    @Override
    public void changesOfAccess(int groupsNumber) {
        for (int i=groupsNumber;i<groupButtons.size();i++)
            groupButtons.get(i).setVisibility(View.GONE);
    }

    @Override
    public void showGroup(String tournamentTitle, int index) {

    }

}
