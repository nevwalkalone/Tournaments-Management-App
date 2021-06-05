package com.example.managetournamentapp.view.Tournament.RoundGames;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.domain.Participation;
import com.example.managetournamentapp.view.Tournament.RoundGames.fragment.GamesListFragment;

import java.util.ArrayList;

public class RoundGamesActivity extends AppCompatActivity implements GamesListFragment.OnListFragmentInteractionListener, RoundGamesView {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String ROUND_TEAMS_EXTRA = "round_teams_extra";
    private static final String SPECIFIC_GROUP_EXTRA = "specific_group_extra";
    RoundGamesViewModel viewModel;
    private static AlertDialog POPUP_ACTION;
    private String tournamentTitle;
    private int roundTeamsNumber;
    private int specificGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_games);
        viewModel = new ViewModelProvider(this).get(RoundGamesViewModel.class);
        viewModel.getPresenter().setView(this);

        tournamentTitle = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        roundTeamsNumber = Integer.parseInt(this.getIntent().getStringExtra(ROUND_TEAMS_EXTRA));
        specificGroup = Integer.parseInt(this.getIntent().getStringExtra(SPECIFIC_GROUP_EXTRA));

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            viewModel.getPresenter().findGames(tournamentTitle, roundTeamsNumber, specificGroup);
            GamesListFragment gamesListFragment = GamesListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, gamesListFragment)
                    .commit();
        }
    }


    @Override
    public void showPopup(Game game) {
        POPUP_ACTION = showPopUp(R.layout.game_score_popup, R.id.save_button, R.id.txt_scoreA, R.id.txt_scoreB, game);
        POPUP_ACTION.show();
    }

    public AlertDialog showPopUp(int layoutId, int btn1, int txt1, int txt2, Game game) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        Button saveButton = (Button) customLayout.findViewById(btn1);
        EditText edit1 = customLayout.findViewById(txt1);
        EditText edit2 = customLayout.findViewById(txt2);
        saveButton.setOnClickListener(v -> viewModel.getPresenter().onSave(game, edit1.getText().toString(), edit2.getText().toString()));

        return dialog;
    }


    @Override
    public void onListFragmentInteraction(Game item) {
        viewModel.getPresenter().onPressed(item);
    }

    @Override
    public ArrayList<Game> getGamesList() {
        return viewModel.getPresenter().getResults();
    }


    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void recreateView() {
        POPUP_ACTION.dismiss();
        POPUP_ACTION = null;
        recreate();
    }
}
