package com.example.managetournamentapp.view.Player.CreateTeam;

import com.example.managetournamentapp.dao.PlayerDAO;
import com.example.managetournamentapp.dao.TeamDAO;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.domain.Sport;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.domain.TournamentType;
import com.example.managetournamentapp.domain.User;
import com.example.managetournamentapp.memoryDao.MemoryLoggedInUser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateTeamPresenter {
    private CreateTeamView view;
    private ArrayList<String> sportTypes;
    private Team connectedTeam;
    private Player player = null;
    private PlayerDAO playerDAO;
    private TeamDAO teamDAO;


    public CreateTeamPresenter() {
        sportTypes = findSportTypes();
    }

    public void showPreviousInfo(String teamName) {
        if (teamName == null)
            return;
        connectedTeam = teamDAO.find(teamName);
        if (connectedTeam == null)
            return;

        view.setTeamName(connectedTeam.getName());
        view.setTeamColors(connectedTeam.getColors());
        view.setSportType(getTypeIndex(connectedTeam.getSportType().getName()));
        view.lockSportType();

    }


    public void onSaveTeam() {
        String name = view.getTeamName();
        String colors = view.getTeamColors();
        String sportType = sportTypes.get(view.getSportType());


        if (name.length() < 5 || name.length() > 20 || !validateName(name)) {
            view.showPopUp(view, "Name must be at least 5 chars and no longer than 20 chars!");
        }
        else if (colors.length() < 3 || colors.length() > 20 || !validateName(colors)) {
            view.showPopUp(view, "Color must be at least 3 chars and no longer than 20 chars!");
        } else {
            // IF TEAM IS NEW!
            if (connectedTeam == null) {
                Player player = ((Player) (new MemoryLoggedInUser()).getUser());
                Team team = new Team(name, new Sport(sportType), player.getAgeDivision(), player, colors);
                teamDAO.save(team);
            } else {
                connectedTeam.setName(name);
                connectedTeam.setColors(colors);
            }
            view.startSaveTeam(player.getCredentials().getUsername());
        }
    }

    public ArrayList<String> getSportTypes() {
        return sportTypes;
    }

    private int getTypeIndex(String sportType) {
        for (int i = 0; i < sportTypes.size(); i++) {
            if (sportTypes.get(i).equals(sportType))
                return i;
        }
        return 0;
    }

    private ArrayList<String> findSportTypes() {
        ArrayList<String> sportTypes = new ArrayList<>();
        for (int i = 0; i < TournamentType.values().length; i++) {
            sportTypes.add(TournamentType.values()[i].toString());
        }
        return sportTypes;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void setView(CreateTeamView view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

    public boolean validateName(String name) {
        String valid = "^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(valid);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }


    public void onHomePage(){
        User user = new MemoryLoggedInUser().getUser();

        view.backToHomePage(user.getCredentials().getUsername());

    }


}
