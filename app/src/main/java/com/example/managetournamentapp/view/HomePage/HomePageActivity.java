package com.example.managetournamentapp.view.HomePage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.OrganizerDAOMemory;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.CreatedTournamentsViewModel;
import com.example.managetournamentapp.view.Organizer.CreatedTournaments.fragment.TournamentListFragment;
import com.example.managetournamentapp.view.User.Login.LoginActivity;
import com.example.managetournamentapp.view.User.Register.RegisterActivity;

import java.util.ArrayList;


public class HomePageActivity extends AppCompatActivity implements TournamentListFragment.OnListFragmentInteractionListener, View.OnClickListener {

    public static final String TOURNAMENT_TITLE_EXTRA = "tournament_title_extra";
    private Button btn;
    HomePageViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn = (Button) findViewById(R.id.connect_button);


        btn.setOnClickListener(this);


        viewModel = new ViewModelProvider(this).get(HomePageViewModel.class);

        if (findViewById(R.id.fragment_container) != null) {

            // Activity is recreated, do not add fragment twice
            if (savedInstanceState != null) {
                return;
            }

            viewModel.getPresenter().findTournaments();

            TournamentListFragment tournamentListFragment = TournamentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, tournamentListFragment)
                    .commit();
        }

    }

    @Override
    public void onListFragmentInteraction(Tournament item) {
        Intent intent = new Intent();
        intent.putExtra(TOURNAMENT_TITLE_EXTRA, item.getTitle());
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    @Override
    public ArrayList<Tournament> getTournamentList() {
        return viewModel.getPresenter().getResults();
    }

    public void showPopUp(View view, int layoutId, int btn1, int btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();
        Button firstButton = (Button) customLayout.findViewById(btn1);
        Button secondButton = (Button) customLayout.findViewById(btn2);
        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        dialog.show();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.connect_button) {
            showPopUp(v, R.layout.register_login, R.id.login_button, R.id.register_button);
        }
        if (v.getId() == R.id.login_button) {
            Toast.makeText(this,
                    "LOGIN",
                    Toast.LENGTH_SHORT)
                    .show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.register_button) {
            Toast.makeText(this,
                    "REGISTER",
                    Toast.LENGTH_SHORT)
                    .show();
            showPopUp(v, R.layout.register_selection, R.id.organizer_register, R.id.player_register);
        }
        if (v.getId() == R.id.organizer_register) {
            Toast.makeText(this,
                    "ORGANIZER",
                    Toast.LENGTH_SHORT)
                    .show();

        }
        if (v.getId() == R.id.player_register) {
            Toast.makeText(this,
                    "PLAYER",
                    Toast.LENGTH_SHORT)
                    .show();

        }
    }
}