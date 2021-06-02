package com.example.managetournamentapp.view.User.Login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;
import com.example.managetournamentapp.view.Player.PlayerPage.PlayerPageActivity;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerView;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerViewModel;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private Button loginBtn;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getPresenter().setView(this);
        loginBtn = (Button) findViewById(R.id.complete_login);
        loginBtn.setOnClickListener(this);
    }


    @Override
    public String getUsername() {
        EditText USERNAME = (EditText) findViewById(R.id.login_input_username);
        return USERNAME.getText().toString();
    }

    @Override
    public String getPassword() {

        EditText PASSWORD = (EditText) findViewById(R.id.login_input_password);
        return PASSWORD.getText().toString();
    }

    @Override
    public void showPopUp(LoginView view, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();
        Button OKbtn = (Button) customLayout.findViewById(R.id.OK_popup);
        TextView errorMsg = (TextView) customLayout.findViewById(R.id.error_messsage);      // display message we want.
        errorMsg.setText(msg);
        OKbtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.complete_login) {
            viewModel.getPresenter().validateCredentials();
        }
   }

    public void startPlayerPage(){
        Intent intent = new Intent(this, PlayerPageActivity.class);
        startActivity(intent);
    }

    public void startOrganizerPage(){
        Intent intent = new Intent(this, OrganizerPageActivity.class);
        startActivity(intent);
    }

}