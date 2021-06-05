package com.example.managetournamentapp.view.HomePage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.view.User.Login.LoginActivity;
import com.example.managetournamentapp.view.User.RegisterOrganizer.RegisterOrganizerActivity;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerActivity;



public class HomePageActivity extends AppCompatActivity implements HomePageView {

    private Button connectBtn;
    private Button browseBtn;
    HomePageViewModel viewModel;
    private static boolean first=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Memory Initialization
        if (first){
            new MemoryInitializer().prepareData();
            first = false;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        viewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
        viewModel.getPresenter().setView(this);



        connectBtn = (Button) findViewById(R.id.connect_button);
        browseBtn = (Button) findViewById(R.id.browse_button);
        connectBtn.setOnClickListener(v->viewModel.getPresenter().onConnectAction());
        browseBtn.setOnClickListener(v->viewModel.getPresenter().onBrowseAction());

    }


    public void showPopUp( int layoutId, int btn1, int btn2, boolean firstPopup) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        //log in button or org register button
        Button firstButton = (Button) customLayout.findViewById(btn1);
        //register button or player register button
        Button secondButton = (Button) customLayout.findViewById(btn2);

        if (firstPopup){
            firstButton.setOnClickListener(v->viewModel.getPresenter().onLogInAction());
            secondButton.setOnClickListener(v->viewModel.getPresenter().onRegisterAction());
        }
       else{
            firstButton.setOnClickListener(v->viewModel.getPresenter().onOrganizerRegisterAction());
            secondButton.setOnClickListener(v->viewModel.getPresenter().onPlayerRegisterAction());
        }
        dialog.show();
    }

    @Override
    public void connectAction() {
        showPopUp(R.layout.register_login, R.id.login_button, R.id.register_button,true);
    }

    @Override
    public void loginAction(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void registerAction(){
        Toast.makeText(this,
                "REGISTER",
                Toast.LENGTH_SHORT)
                .show();
        showPopUp( R.layout.register_selection, R.id.organizer_register, R.id.player_register,false);
    }

    @Override
    public void organizerRegisterAction() {
        Toast.makeText(this,
                "ORGANIZER",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, RegisterOrganizerActivity.class);
        startActivity(intent);
    }

    @Override
    public void playerRegisterAction() {
        Toast.makeText(this,
                "PLAYER",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, RegisterPlayerActivity.class);
        startActivity(intent);
    }


    //TODO
    @Override
    public void browseAction(){

    }

    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomePageActivity.this);
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