package com.example.managetournamentapp.view.Organizer.ManageTournaments;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;


public class ManageTournamentsActivity extends AppCompatActivity implements ManageTournamentsView,SearchView.OnQueryTextListener {

    ManageTournamentsPresenter presenter;
    private ListView itemListView;
    private SearchView searchListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new MemoryInitializer().prepareData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_items);


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }




}
