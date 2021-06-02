package com.example.managetournamentapp.view.User.RegisterOrganizer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.view.Organizer.OrganizerPage.OrganizerPageActivity;


import org.w3c.dom.Text;

public class RegisterOrganizerActivity extends AppCompatActivity implements RegisterOrganizerView, View.OnClickListener {

    RegisterOrganizerViewModel viewModel;
    public static final String ORGANIZER_USERNAME = "ORGANIZER_USERNAME";
    private Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_organizer);


        viewModel = new ViewModelProvider(this).get(RegisterOrganizerViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().showPreviousInfo();
        saveBtn = (Button) findViewById(R.id.saveOrganizerBtn);
        saveBtn.setOnClickListener(this);

    }

    public void showPopUp(RegisterOrganizerView view, String msg) {
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


    public Organizer getConnectedOrganizer() {
        if (("1").equals(this.getIntent().getStringExtra("IS_EDIT"))) {
            return (Organizer) (new MemoryLoggedInUser()).getUser();
        } else {
            return null;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveOrganizerBtn) {
            viewModel.getPresenter().handleOrganizerData();
        }
    }

    public void startOrganizerPage(){
        Intent intent = new Intent(this, OrganizerPageActivity.class);
        startActivity(intent);
    }

    @Override
    public String getUsername() {
        EditText USERNAME = (EditText) findViewById(R.id.username);
        return USERNAME.getText().toString();
    }

    @Override
    public String getPassword() {
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        return PASSWORD.getText().toString();
    }

    @Override
    public String getName() {
        EditText NAME = (EditText) findViewById(R.id.name);
        return NAME.getText().toString();
    }

    @Override
    public String getSurname() {
        EditText SURNAME = (EditText) findViewById(R.id.surname);
        return SURNAME.getText().toString();
    }

    @Override
    public String getPhoneNumber() {
        EditText PHONE = (EditText) findViewById(R.id.phone);
        return PHONE.getText().toString();
    }

    @Override
    public String getEmail() {
        EditText EMAIL = (EditText) findViewById(R.id.email);
        return EMAIL.getText().toString();
    }

    @Override
    public String getBirthDate() {
        EditText BIRTHDATE = (EditText) findViewById(R.id.birthdate);
        return BIRTHDATE.getText().toString();      //
    }

    @Override
    public Credentials getCredentials() {

        EditText USERNAME = (EditText) findViewById(R.id.username);
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        return new Credentials(USERNAME.getText().toString(), PASSWORD.getText().toString());
    }

    @Override
    public String getOrganizerTitle() {
        EditText TITLE = (EditText) findViewById(R.id.organizer_title);
        return TITLE.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        EditText USERNAME = (EditText) findViewById(R.id.username);
        USERNAME.setText(username);
    }

    @Override
    public void setPassword(String password) {
        EditText PASSWORD = (EditText) findViewById(R.id.password);
        PASSWORD.setText(password);
    }

    @Override
    public void setName(String name) {
        EditText NAME = (EditText) findViewById(R.id.name);
        NAME.setText(name);
    }

    @Override
    public void setSurname(String surname) {
        EditText SURNAME = (EditText) findViewById(R.id.surname);
        SURNAME.setText(surname);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        EditText PHONE = (EditText) findViewById(R.id.phone);
        PHONE.setText(phoneNumber);
    }

    @Override
    public void setEmail(String email) {
        EditText EMAIL = (EditText) findViewById(R.id.email);
        EMAIL.setText(email);
    }

    @Override
    public void setBirthdate(String birthdate) {
        EditText BIRTHDATE = (EditText) findViewById(R.id.birthdate);
        BIRTHDATE.setText(birthdate);
    }

    @Override
    public void setCredentials(Credentials credentials) {
        //TODO

    }

    @Override
    public void setTitle(String title) {
        EditText TITLE = (EditText) findViewById(R.id.organizer_title);
        TITLE.setText(title);
    }


}