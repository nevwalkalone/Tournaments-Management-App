package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.widget.Button;
import android.widget.TextView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.OrganizerTournamentsActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerInfo.OrganizerInfoActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;


public class OrganizerPageActivity extends AppCompatActivity implements OrganizerPageView {
    private OrganizerPageViewModel viewModel;
    private TextView txtOrganizerName;
    private Button btnOrganizerAccount;
    private Button btnOrganizerTournaments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_page);
        viewModel = new ViewModelProvider(this).get(OrganizerPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtOrganizerName = findViewById(R.id.title_organizer_name);
        btnOrganizerAccount = findViewById(R.id.organizer_account);
        btnOrganizerTournaments = findViewById(R.id.organizer_tournaments);

        btnOrganizerAccount.setOnClickListener(v -> viewModel.getPresenter().onOrganizerAccount());
        btnOrganizerTournaments.setOnClickListener(v -> viewModel.getPresenter().onOrganizerTournaments());
        viewModel.getPresenter().findOrganizerInfo();
    }

    /**
     * Starts Organizer's Account Activity
     */
    public void toOrganizerAccount() {
        Intent intent = new Intent(OrganizerPageActivity.this, OrganizerInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Starts CreatedTournaments Activity
     */
    public void toOrganizerTournaments() {
        Intent intent = new Intent(OrganizerPageActivity.this, OrganizerTournamentsActivity.class);
        startActivity(intent);

    }

    public void setTitle(String organizerTitle){
        txtOrganizerName.setText(organizerTitle);
    }

    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(OrganizerPageActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
}