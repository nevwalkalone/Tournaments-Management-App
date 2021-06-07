package com.example.managetournamentapp.view.Team.AddParticipation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.Team.ParticipatingTournaments.ParticipatingTournamentsActivity;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;
import java.util.ArrayList;

public class AddParticipationActivity  extends AppCompatActivity implements  AddParticipationView, TournamentListFragment.OnListFragmentInteractionListener, View.OnClickListener{
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    private static AlertDialog POPUP_ACTION;
    private String teamName;
    private String tournamentName;
    AddParticipationViewModel viewModel;
    ImageButton btnHome;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        teamName =  this.getIntent().getStringExtra(TEAM_NAME_EXTRA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participation);
        viewModel = new ViewModelProvider(this).get(AddParticipationViewModel.class);
        viewModel.getPresenter().setView(this);
        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());

        if (findViewById(R.id.fragment_container) != null){

            if (savedInstanceState != null){
                return;
            }

            viewModel.getPresenter().findTournaments( teamName  );

            TournamentListFragment tournamentListFragment = TournamentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, tournamentListFragment)
                    .commit();
        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String newButton=b.getText().toString();

        if ("OK".equals(newButton)) {
            viewModel.getPresenter().onStartPartTournaments();
            POPUP_ACTION.dismiss();
            recreate();
        }
        else if (v.getId() == R.id.invite_player_popup) {
            viewModel.getPresenter().onAddParticipation(tournamentName);
            POPUP_ACTION.dismiss();
            POPUP_ACTION = showPopUp(R.layout.invite_player_popup, "Succesfully Joined " + tournamentName + "!", R.id.invite_player_popup, R.id.account_player_popup,true);
            POPUP_ACTION.show();
        }
        else if (v.getId() == R.id.account_player_popup) {
            viewModel.getPresenter().onTournamentPage(tournamentName);
        }

    }

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, boolean changePopup) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);
        textMsg.setText(msg);

        Button firstButton = (Button) customLayout.findViewById(btn1);
        firstButton.setText("JOIN");

        Button secondButton = (Button) customLayout.findViewById(btn2);

        if(changePopup){
            firstButton.setText("OK");
            secondButton.setVisibility(View.GONE);
        }
        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        return dialog;
    }

    //TODO FIXING
    @Override
    public void onListFragmentInteraction(Tournament item) {
       tournamentName = item.getTitle();
       POPUP_ACTION = showPopUp((R.layout.invite_player_popup), "Do you want to join "+item.getTitle()+"?",R.id.invite_player_popup, R.id.account_player_popup,false);
       POPUP_ACTION.show();

    }

    @Override
    public ArrayList<Tournament> getTournamentList() {
        return viewModel.getPresenter().getResults();
    }

    @Override
    public void startTournamentPage(Tournament tournament){
        Intent intent = new Intent(this, TournamentPageActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA,tournament.getTitle());
        startActivity(intent);
    }

    @Override
    public void startPlayerPage(String userName) {
        Intent intent = new Intent(this, PlayerPageActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA, userName);
        startActivity(intent);
    }

    @Override
    public void backToHomePage(String name) {
        Intent intent = new Intent(this, PlayerPageActivity.class);
        intent.putExtra(PLAYER_USERNAME_EXTRA,name);
        startActivity(intent);
    }
}
