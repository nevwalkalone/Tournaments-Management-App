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
//import com.example.managetournamentapp.dao.LoggedInUserDAO;
//import com.example.managetournamentapp.memoryDao.LoggenInUserDAOMemory;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.memoryDao.TournamentDAOMemory;
import com.example.managetournamentapp.util.Quadruple;
import com.example.managetournamentapp.view.Util.AdvancedListAdapter;


public class ManageTournamentsActivity extends AppCompatActivity implements ManageTournamentsView,SearchView.OnQueryTextListener {

    ManageTournamentsPresenter presenter;

    private ListView itemListView;
    private SearchView searchListView;
    private AdvancedListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new MemoryInitializer().prepareData();
        String tempOrg = "ESKA";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_items);


        adapter = new AdvancedListAdapter(this);

        itemListView = (ListView) findViewById(R.id.item_list_view);
        itemListView.setAdapter(adapter);
        itemListView.setTextFilterEnabled(true);
        searchListView = (SearchView) findViewById(R.id.items_list_search_view);
        searchListView.setIconifiedByDefault(false);
        searchListView.setOnQueryTextListener(this);

        presenter = new ManageTournamentsPresenter(this,new TournamentDAOMemory(), new OrganizerDAOMemory(),tempOrg);

        findViewById(R.id.item_add_new).setOnClickListener(view -> presenter.onStartAddNew());
        itemListView.setOnItemClickListener((parent, view, position, id) -> presenter.onClickItem(((Quadruple)parent.getItemAtPosition(position)).getUID()));
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    @Override
    public void clickItem(int uid) {

    }

    @Override
    public void clickItemList(int uid) {

    }

    @Override
    public void startAddNew() {

    }

    @Override
    public void loadSource(ArrayList<Quadruple> input) {

    }

    @Override
    public void setPageName(String value) {

    }

    @Override
    public void showToast(String value) {

    }

    @Override
    public boolean shouldLoadItemsOnClick() {
        return false;
    }

    @Override
    public Integer getAttachedAuthorID() {
        return null;
    }

    @Override
    public Integer getAttachedPublisherID() {
        return null;
    }
}
