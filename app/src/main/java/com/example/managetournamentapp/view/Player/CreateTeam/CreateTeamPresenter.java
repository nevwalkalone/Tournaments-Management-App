package com.example.managetournamentapp.view.Player.CreateTeam;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.TournamentType;
import com.example.managetournamentapp.memoryDao.MemoryInitializer;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;
import com.example.managetournamentapp.memoryDao.PlayerDAOMemory;
import com.example.managetournamentapp.memoryDao.TeamDAOMemory;
import com.example.managetournamentapp.view.User.RegisterPlayer.RegisterPlayerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreateTeamPresenter {
    private CreateTeamView view;
    private ArrayList<String> sportTypes;
    private Team connectedTeam;

    public CreateTeamPresenter() {

        sportTypes = findSportTypes();
    }

    public void showPreviousInfo() {
        if (view.getConnectedTeamName() != null)//edit mode
        {
            connectedTeam = (new TeamDAOMemory()).find( view.getConnectedTeamName()  );
            view.setTeamName(connectedTeam.getName());
            view.setTeamColors(connectedTeam.getColors());
            view.setSportType( getTypeIndex(connectedTeam.getSportType().getName()) );
            view.lockSportType();
        }
    }


    public boolean onSaveTeam(){
        String name = view.getTeamName();
        String colors = view.getTeamColors();
        String sportType = sportTypes.get( view.getSportType() );

        if (name.length() < 5 || name.length() > 20) {

        }else if (colors.length() < 3 || colors.length() > 20) {

        }else{
            // IF USER IS NEW!
            if ( connectedTeam == null) {
                Player player = ( (Player) (new MemoryLoggedInUser()).getUser() );
                Team team = new Team( name, new Sport(sportType) , player.getAgeDivision(), player , colors );
                (new TeamDAOMemory() ).save(team);

            } else {
                connectedTeam.setName(name);
                connectedTeam.setColors(colors);

            }
            return true;
        }
        return false;
    }

    public ArrayList<String>  getSportTypes(){
        return sportTypes;
    }

    private int getTypeIndex(String sportType){
        for (int i = 0; i< sportTypes.size(); i++){
            if (sportTypes.get(i).equals(sportType) )
                return i;
        }
        return 0;
    }

    private ArrayList<String> findSportTypes(){
        ArrayList<String> sportTypes = new ArrayList<>();
        for (int i = 0; i< TournamentType.values().length; i++){
            sportTypes.add(TournamentType.values()[i].toString());
        }
        return  sportTypes;
    }

    public void setView(CreateTeamView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }


}
