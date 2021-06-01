package com.example.managetournamentapp.view.Player.PlayerInfo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;


public class PlayerInfoActivity extends AppCompatActivity implements PlayerInfoView {
    private PlayerInfoViewModel viewModel;
    Button btnEditPlayer;
    Button btnDeletePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo erase
        new MemoryInitializer().prepareData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

//
//        Log.d("BookSearchActivity", "Search criteria: " + titleCriterion
//                + " " + authorCriterion);

        viewModel = new ViewModelProvider(this).get(PlayerInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findPlayerInfo( (new MemoryLoggedInUser()).getUser());

        btnEditPlayer = findViewById(R.id.edit_player_button);
        btnDeletePlayer = findViewById(R.id.delete_player_button);

        btnEditPlayer.setOnClickListener(v -> viewModel.getPresenter().onEditPlayer());
        btnDeletePlayer.setOnClickListener(v -> viewModel.getPresenter().onDeletePlayer());

    }


    public void setUsername(String username){
        ((TextView)findViewById(R.id.text_username)).setText(username);
    }

    public void setPassword(String password){
        ((TextView)findViewById(R.id.text_password)).setText(password);
    }

    public void setName(String name){
        ((TextView)findViewById(R.id.text_name)).setText(name);
    }

    public void setSurname(String surname){
        ((TextView)findViewById(R.id.text_surname)).setText(surname);
    }

    public void setPhone(String phone){
        ((TextView)findViewById(R.id.text_phone)).setText(phone);
    }

    public void setEmail(String email){
        ((TextView)findViewById(R.id.text_email)).setText(email);
    }

    public void setLocation(String location){
        ((TextView)findViewById(R.id.text_location)).setText(location);
    }

    public void setBirthDate(String date){
        ((TextView)findViewById(R.id.text_birth_date)).setText(date);
    }


    public void startEditPlayer(Player player){

    }

    public void startDeletePlayer(Player player){
        //todo check
        (new PlayerDAOMemory()).delete(player);
        (new MemoryLoggedInUser()).clear();

    }
}
