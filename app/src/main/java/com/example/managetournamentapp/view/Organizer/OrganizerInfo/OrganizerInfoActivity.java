package com.example.managetournamentapp.view.Organizer.OrganizerInfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.view.User.RegisterOrganizer.RegisterOrganizerActivity;

public class OrganizerInfoActivity extends AppCompatActivity implements OrganizerInfoView {
    private OrganizerInfoViewModel viewModel;
    Button btnEditOrganizer;
    Button btnDeleteOrganizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new MemoryInitializer().prepareData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_info);

        viewModel = new ViewModelProvider(this).get(OrganizerInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findOrganizerInfo((new MemoryLoggedInUser()).getUser());

        btnEditOrganizer = findViewById(R.id.edit_organizer_button);
        btnDeleteOrganizer = findViewById(R.id.delete_organizer_button);

        btnEditOrganizer.setOnClickListener(v -> viewModel.getPresenter().onEditOrganizer());
        btnDeleteOrganizer.setOnClickListener(v -> viewModel.getPresenter().onDeleteOrganizer());


    }

    @Override
    public void setUsername(String username) {
        ((TextView) findViewById(R.id.text_username)).setText(username);
    }

    @Override
    public void setPassword(String password) {
        ((TextView) findViewById(R.id.text_password)).setText(password);
    }

    @Override
    public void setName(String name) {
        ((TextView) findViewById(R.id.text_name)).setText(name);
    }

    @Override
    public void setSurname(String surname) {
        ((TextView) findViewById(R.id.text_surname)).setText(surname);
    }

    @Override
    public void setPhone(String phone) {
        ((TextView) findViewById(R.id.text_phone)).setText(phone);
    }

    @Override
    public void setEmail(String email) {
        ((TextView) findViewById(R.id.text_email)).setText(email);
    }

    @Override
    public void setBirthDate(String date) {
        ((TextView) findViewById(R.id.text_birth_date)).setText(date);
    }

    @Override
    public void setTitle(String title) {
        ((TextView) findViewById(R.id.text_organizer_title)).setText(title);
    }

    @Override
    public void startEditOrganizer(Organizer organizer) {
        Intent intent = new Intent(OrganizerInfoActivity.this, RegisterOrganizerActivity.class);
        intent.putExtra("IS_EDIT", "1");
        startActivity(intent);
    }

    @Override
    public void startDeleteOrganizer(Organizer organizer) {

    }


}
