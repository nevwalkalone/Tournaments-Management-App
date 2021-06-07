package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.OrganizerTournamentsActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerInfo.OrganizerInfoActivity;
import com.example.managetournamentapp.view.User.Login.LoginActivity;


public class OrganizerPageActivity extends AppCompatActivity implements OrganizerPageView {
    private OrganizerPageViewModel viewModel;
    private static final String ORGANIZER_TITLE_EXTRA = "organizer_title_extra";
    private TextView txtOrganizerName;
    private Button btnOrganizerAccount;
    private Button btnOrganizerTournaments;
    private Button btnLogOut;
    private String organizerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_page);
        organizerUsername = this.getIntent().getStringExtra(ORGANIZER_TITLE_EXTRA);

        viewModel = new ViewModelProvider(this).get(OrganizerPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findOrganizerInfo(organizerUsername);

        txtOrganizerName = findViewById(R.id.title_organizer_name);
        btnOrganizerAccount = findViewById(R.id.organizer_account);
        btnOrganizerTournaments = findViewById(R.id.organizer_tournaments);
        btnLogOut = findViewById(R.id.log_out_button);

        txtOrganizerName.setText(viewModel.getPresenter().getOrganizerTitle());
        btnOrganizerAccount.setOnClickListener(v -> viewModel.getPresenter().onOrganizerAccount());
        btnOrganizerTournaments.setOnClickListener(v -> viewModel.getPresenter().onOrganizerTournaments());
        btnLogOut.setOnClickListener(v->viewModel.getPresenter().onLogOut());
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
    public void toOrganizerTournaments(String title) {
        Intent intent = new Intent(OrganizerPageActivity.this, OrganizerTournamentsActivity.class);
        intent.putExtra(ORGANIZER_TITLE_EXTRA,title);
        startActivity(intent);

    }


    public void setTitle(String organizerTitle){
        txtOrganizerName.setText(organizerTitle);
    }

    @Override
    public void logOut() {
        Toast.makeText(this,
                "LOGGED OUT",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(OrganizerPageActivity.this, LoginActivity.class);
        startActivity(intent);
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