package com.example.managetournamentapp.view.Team.AddParticipation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.Team.ParticipatingTournaments.ParticipatingTournamentsActivity;
import com.example.managetournamentapp.view.Tournament.TournamentPage.TournamentPageActivity;
import java.util.ArrayList;

public class AddParticipationActivity  extends AppCompatActivity implements  AddParticipationView, TournamentListFragment.OnListFragmentInteractionListener, View.OnClickListener{
    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static AlertDialog POPUP_ACTION;
    private String teamName;
    private String tournamentName;
    AddParticipationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        teamName =  this.getIntent().getStringExtra(TEAM_NAME_EXTRA);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participation);
        viewModel = new ViewModelProvider(this).get(AddParticipationViewModel.class);
        viewModel.getPresenter().setView(this);

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
    public void startPartTournaments(String teamName){
        Intent intent = new Intent(this, ParticipatingTournamentsActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA,teamName);
        startActivity(intent);
    }


}
