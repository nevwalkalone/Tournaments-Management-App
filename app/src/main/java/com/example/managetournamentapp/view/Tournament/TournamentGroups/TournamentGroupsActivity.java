package com.example.managetournamentapp.view.Tournament.TournamentGroups;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Tournament.GroupRankings.GroupRankingsActivity;
import com.example.managetournamentapp.view.Tournament.RoundGames.RoundGamesActivity;
import java.util.ArrayList;


public class TournamentGroupsActivity extends AppCompatActivity implements TournamentGroupsView {
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String ROUND_TEAMS_EXTRA = "round_teams_extra" ;
    private static final String SPECIFIC_GROUP_EXTRA = "specific_group_extra" ;
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    private static AlertDialog POPUP_ACTION;
    private TournamentGroupsViewModel viewModel;
    String tournamentTitle;
    ArrayList<Button> groupButtons = new ArrayList<>();
    ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        setContentView(R.layout.activity_tournament_groups);

        viewModel = new ViewModelProvider(this).get(TournamentGroupsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findTournamentInfo(tournamentTitle);

        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());

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
    public void showPopup(int index){
        POPUP_ACTION = showPopUp(R.layout.group_action_popup, R.id.games_button, R.id.rankings_button, index);
        POPUP_ACTION.show();
    }

    public AlertDialog showPopUp(int layoutId, int btn1, int btn2, int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        Button firstButton = (Button) customLayout.findViewById(btn1);
        Button secondButton = (Button) customLayout.findViewById(btn2);
        firstButton.setOnClickListener(v -> viewModel.getPresenter().onGames(index) );
        secondButton.setOnClickListener(v -> viewModel.getPresenter().onRankings(index) );
        return dialog;
    }

    @Override
    public void changesOfAccess(int groupsNumber) {
        for (int i=groupsNumber;i<groupButtons.size();i++)
            groupButtons.get(i).setVisibility(View.GONE);
    }

    @Override
    public void showGroupGames(String tournamentGame, int roundTeamsNumber, int index) {
        Intent intent = new Intent(TournamentGroupsActivity.this, RoundGamesActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, tournamentTitle);
        intent.putExtra(ROUND_TEAMS_EXTRA, String.valueOf(roundTeamsNumber));
        intent.putExtra(SPECIFIC_GROUP_EXTRA, String.valueOf(index));
        startActivity(intent);
    }

    @Override
    public void showGroupRankings(String tournamentGame, int roundTeamsNumber, int index) {
        Intent intent = new Intent(TournamentGroupsActivity.this, GroupRankingsActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, tournamentTitle);
        intent.putExtra(SPECIFIC_GROUP_EXTRA, String.valueOf(index));
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
