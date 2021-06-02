package com.example.managetournamentapp.view.Organizer.OrganizerPage;

import android.content.Intent;
import android.os.Bundle;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.widget.Button;
import android.widget.TextView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.OrganizerTournamentsActivity;
import com.example.managetournamentapp.view.Organizer.OrganizerInfo.OrganizerInfoActivity;


public class OrganizerPageActivity extends AppCompatActivity implements OrganizerPageView {
    private OrganizerPageViewModel viewModel;
    private TextView txtOrganizerName;
    private Button btnOrganizerAccount;
    private Button btnOrganizerTournaments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_page);
        viewModel = new ViewModelProvider(this).get(OrganizerPageViewModel.class);
        viewModel.getPresenter().setView(this);

        txtOrganizerName = findViewById(R.id.title_organizer_name);
        btnOrganizerAccount = findViewById(R.id.organizer_account);
        btnOrganizerTournaments = findViewById(R.id.organizer_tournaments);

        txtOrganizerName.setText(((Organizer) (new MemoryLoggedInUser()).getUser()).getTitle());

        btnOrganizerAccount.setOnClickListener(v -> viewModel.getPresenter().onOrganizerAccount());
        btnOrganizerTournaments.setOnClickListener(v -> viewModel.getPresenter().onOrganizerTournaments());

    }

    /**
     * Stars Organizer's Account Activity
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


}