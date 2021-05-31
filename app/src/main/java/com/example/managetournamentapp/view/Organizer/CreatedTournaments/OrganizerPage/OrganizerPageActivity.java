package com.example.managetournamentapp.view.Organizer.CreatedTournaments.OrganizerPage;

import android.os.Bundle;

import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.managetournamentapp.R;

public class OrganizerPageActivity extends AppCompatActivity implements View.OnClickListener, OrganizerPageView {
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


        txtOrganizerName.setText( ((Player) (new MemoryLoggedInUser()).getUser()).getName());

    }

    @Override
    public void onClick(View v) {

    }
}