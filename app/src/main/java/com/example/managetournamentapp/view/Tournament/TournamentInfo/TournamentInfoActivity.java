package com.example.managetournamentapp.view.Tournament.TournamentInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.CreateTournament.CreateTournamentActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.OrganizerTournamentsActivity;

public class TournamentInfoActivity extends AppCompatActivity implements TournamentInfoView {
    private TournamentInfoViewModel viewModel;
    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    String tournamentName;
    Button btnEditTournament;
    Button btnDeleteTournament;
    private AlertDialog POPUP_ACTION;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);
        tournamentName = this.getIntent().getStringExtra(TOURNAMENT_TITLE_EXTRA);
        viewModel = new ViewModelProvider(this).get(TournamentInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findTournamentInfo(tournamentName);

        btnEditTournament = findViewById(R.id.edit_button);
        btnDeleteTournament = findViewById(R.id.delete_button);

        btnEditTournament.setOnClickListener(v -> viewModel.getPresenter().onEditTournament());
        btnDeleteTournament.setOnClickListener(v -> viewModel.getPresenter().onDeleteTournament());

       viewModel.getPresenter().findAccess();
    }

    @Override
    public void setTeamsNumber(String teamsNumber) {
        ((TextView)findViewById(R.id.text_teams_number)).setText(teamsNumber);
    }

    @Override
    public void setLocation(String location) {
        ((TextView)findViewById(R.id.text_location)).setText(location);
    }

    @Override
    public void setStartDate(String startDate) {
        ((TextView)findViewById(R.id.text_start_date)).setText(startDate);
    }

    @Override
    public void setFinishDate(String finishDate) {
        ((TextView)findViewById(R.id.text_finish_date)).setText(finishDate);
    }

    @Override
    public void setsportType(String sportType) {
        ((TextView)findViewById(R.id.text_sport_type)).setText(sportType);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.text_title)).setText(title);
    }

    @Override
    public void setAgeDivision(String ageDivision) {
        ((TextView)findViewById(R.id.text_age_division)).setText(ageDivision);
    }

    @Override
    public void setDescription(String description) {
        ((TextView)findViewById(R.id.text_description)).setText(description);
    }

    @Override
    public void startEditTournament() {
        Intent intent = new Intent(TournamentInfoActivity.this, CreateTournamentActivity.class);
        intent.putExtra(TOURNAMENT_TITLE_EXTRA,tournamentName);
        startActivity(intent);
    }

    @Override
    public void yesDeleteTournament(String title) {
        Intent intent = new Intent(TournamentInfoActivity.this, OrganizerPageActivity.class);
        showToast("SUCCESSFULLY DELETED TOURNAMENT.");
        intent.putExtra(ORGANIZER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    @Override
    public void showToast(String txt) {
        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noDeleteTournament() {
        POPUP_ACTION.dismiss();
    }

    @Override
    public void changesOfAccess() {
        btnEditTournament.setVisibility(View.GONE);
        btnDeleteTournament.setVisibility(View.GONE);
    }

    @Override
    public void deleteConfirmation() {
        POPUP_ACTION = showPopUp(R.layout.tournament_delete_popup, "Do you really want to delete this Tournament?", R.id.no_delete, R.id.yes_delete);

        POPUP_ACTION.show();
    }


    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);

        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);

        //no delete
        Button firstButton = (Button) customLayout.findViewById(btn1);
        //yes delete
        Button secondButton = (Button) customLayout.findViewById(btn2);

        textMsg.setText(msg);

        firstButton.setOnClickListener(v->viewModel.getPresenter().onNoDeleteTournament());
        secondButton.setOnClickListener(v->viewModel.getPresenter().onYesDeleteTournament());
        return dialog;
    }

}
