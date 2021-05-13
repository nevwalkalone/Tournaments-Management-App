package com.example.managetournamentapp.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.crypto.spec.PSource;

public class Player extends User {

    private String location;
    private ArrayList<Sport> sportsInterested = new ArrayList<>();

    //teams that I participate as or as a captain
    private ArrayList<Team> teamsJoined = new ArrayList<>();

    //teams that the player is a captain
    private ArrayList<Team> captainInTeams = new ArrayList<>();


    public Player(){

    }

    public Player(String name, String surname, String phoneNumber, String email, Date birthDate, Credentials credentials) {
        super(name, surname, phoneNumber, email, birthDate, credentials);
    }



    public void addJoinedTeam(Team team) {

        if (team == null){
            return;
        }

        /*if (teamsJoined.contains(team)){
            return;
        }*/

        if (team.getCaptain().equals(this)){
            captainInTeams.add(team);
        }
        teamsJoined.add(team);

    }

    public void removeJoinedTeam(Team team) {
        LocalDate.now() < tournament.startDat
        teamsJoined.remove(team);
    }


    public void addSportInterested(Sport sport) {
        sportsInterested.add(sport);
    }

    public void removeSportInterested(Sport sport) {
        sportsInterested.remove(sport);
    }


    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public ArrayList<Sport> getSportsInterested() {
        return sportsInterested;
    }


    public ArrayList<Team> getTeamsJoined() {
        return teamsJoined;
    }



    public void manageRequests(Team team, boolean choice) {

    }


    //TODO check player age
    public boolean canJoin(Team team) {

        if (!sportsInterested.contains(team.getSportType()))
            return false;

        //if player has joined this tournament
        //with another team, he can't join
        for (Participation teamPart : team.getRunningParticipations()) {
            for (Participation playerPart : getRunningParticipations()) {
                if (teamPart.isSimultaneous(playerPart))
                    return false;
            }
        }
        return true;
    }

    public boolean alreadyParticipates (Tournament tournament){
        for (Participation playerPart : getRunningParticipations()) {
            if (tournament.isSimultaneous(playerPart))
                return false;
        }
        return true;
    }


    //all player's participations
    public ArrayList<Participation> getRunningParticipations() {
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Team team : teamsJoined) {
            runningParticipations.addAll(team.getRunningParticipations());
        }
        return runningParticipations;
    }


    public void leaveTeam(Team team) {

    }

    public void createTeam() {

    }

    public void deleteTeam(Team team) {

    }

    public void manageTeam(Team team) {

    }

    public ArrayList<Player> searchPlayers() {
        return null;
    }

    public void invitePlayer(Player player, Team team) {

    }

    public void joinTournament(Tournament tour, Team team) {

    }

    public void leaveTournament(Tournament tour, Team team) {

    }

    @Override
    public String toString() {
        return "Player{" +
                "appearances=" +
                ", location='" + location + '\'' +
                ", availability=" +
                ", isCaptain=" +
                ", sportsInterested=" + sportsInterested +
                ", teamsJoined=" + teamsJoined +
                ", teamsCreated=" +
                '}';
    }

}
