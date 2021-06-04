package com.example.managetournamentapp.view.Player.ReceivedInvites;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Invitation;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.Player.ReceivedInvites.fragment.InvitationListFragment;
import com.example.managetournamentapp.view.Team.TeamPage.TeamPageActivity;

import java.util.ArrayList;

public class ReceivedInvitesActivity extends AppCompatActivity implements ReceivedInvitesView, View.OnClickListener, InvitationListFragment.OnListFragmentInteractionListener {


    public static final String TEAM_NAME_EXTRA = "team_name_extra";
    private static final String PLAYER_USERNAME_EXTRA = "player_username_extra";
    private AlertDialog POPUP_ACTION;
    ReceivedInvitesViewModel viewModel;
    private String playerUsername;
    private Invitation invitationSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_invites);
        playerUsername = this.getIntent().getStringExtra(PLAYER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(ReceivedInvitesViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().setPlayerDAO((new PlayerDAOMemory()));
        viewModel.getPresenter().setTeamDAO((new TeamDAOMemory()));
        viewModel.getPresenter().findInvites(playerUsername);


        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            InvitationListFragment invitationListFragment = InvitationListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, invitationListFragment)
                    .commit();
        }

    }


    @Override
    public ArrayList<Invitation> getInvitationsList() {
        return viewModel.getPresenter().getInvites();
    }

    @Override
    public void startTeamPage() {
        Intent intent = new Intent(this, TeamPageActivity.class);
        intent.putExtra(TEAM_NAME_EXTRA, invitationSelected.getTeam().getName());
        startActivity(intent);
    }

    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2, int btn3,boolean changePopup) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);
        Button firstButton = (Button) customLayout.findViewById(btn1);
        Button secondButton = (Button) customLayout.findViewById(btn2);
        Button thirdButton = (Button) customLayout.findViewById(btn3);
        textMsg.setText(msg);

        if(changePopup){
            customLayout.findViewById(R.id.textView2).setVisibility(View.GONE);
            TextView tempMsg = customLayout.findViewById(btn2);
            tempMsg.setText("OK");

            firstButton.setVisibility(View.GONE);
            thirdButton.setVisibility(View.GONE);
        }

        //(findViewById(R.id.password_row)).setVisibility(View.GONE);
        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        thirdButton.setOnClickListener(this);
        return dialog;
    }


    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String newButton=b.getText().toString();

        if ("OK".equals(newButton)) {
            POPUP_ACTION.dismiss();
            recreate();
        }
        else if (v.getId() == R.id.decline_team_popup) {
            viewModel.getPresenter().declineInvitation(invitationSelected);
            POPUP_ACTION.dismiss();
            POPUP_ACTION = showPopUp(R.layout.manage_invites_popup, "Successfully deleted invitation from " + invitationSelected.getTeam().getName()+" Team", R.id.decline_team_popup, R.id.accept_team_popup, R.id.account_team_popup,true);
            POPUP_ACTION.show();

        }
        else if (v.getId() == R.id.accept_team_popup) {


            viewModel.getPresenter().acceptInvitation(invitationSelected);
            POPUP_ACTION.dismiss();
            POPUP_ACTION = showPopUp(R.layout.manage_invites_popup, "Successfully Joined " + invitationSelected.getTeam().getName()+" Team!", R.id.decline_team_popup, R.id.accept_team_popup, R.id.account_team_popup,true);
            POPUP_ACTION.show();


        } else if (v.getId() == R.id.account_team_popup) {
            viewModel.getPresenter().onTeamPageClick();

        }
    }

    @Override
    public void onListFragmentInteraction(Invitation item) {
        invitationSelected = item;
        POPUP_ACTION = showPopUp(R.layout.manage_invites_popup, "Team: " + invitationSelected.getTeam().getName(), R.id.decline_team_popup, R.id.accept_team_popup, R.id.account_team_popup,false);
        POPUP_ACTION.show();
    }

    @Override
    public ArrayList<Invitation> getInvitationList() {
        return viewModel.getPresenter().getInvites();
    }
}