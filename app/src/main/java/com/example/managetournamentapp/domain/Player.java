package com.example.managetournamentapp.domain;

import java.util.ArrayList;

public class Player {

    private int appearances;
    private String location;
    private boolean availability, isCaptain;
    private ArrayList<Sport> favoriteSports;
    private ArrayList<Team> teamsJoined, teamsCreated;

    public Player(int appearances, String location, boolean availability, boolean isCaptain, ArrayList<Sport> favoriteSports, ArrayList<Team> teamsJoined, ArrayList<Team> teamsCreated) {
        this.appearances = appearances;
        this.location = location;
        this.availability = availability;
        this.isCaptain = isCaptain;
        this.favoriteSports = favoriteSports;
        this.teamsJoined = teamsJoined;
        this.teamsCreated = teamsCreated;
    }

    public Player(int appearances, String location, boolean availability, boolean isCaptain, ArrayList<Sport> favoriteSports) {
        this.appearances = appearances;
        this.location = location;
        this.availability = availability;
        this.isCaptain = isCaptain;
        this.favoriteSports = favoriteSports;
    }

    public void addJoinedTeam(Team team){
        teamsJoined.add(team);
    }

    public void removeJoinedTeam(Team team){
        teamsJoined.remove(team);
    }

    public void addCreatedTeam(Team team){
        teamsCreated.add(team);
    }

    public void removeCreatedTeam(Team team){
        teamsCreated.remove(team);
    }

    public void addFavoriteSport(Sport sport){
        favoriteSports.add(sport);
    }

    public void removeFavoriteSport(Sport sport){
        favoriteSports.remove(sport);
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public ArrayList<Sport> getFavoriteSports() {
        return favoriteSports;
    }

    public void setFavoriteSports(ArrayList<Sport> favoriteSports) {
        this.favoriteSports = favoriteSports;
    }

    public ArrayList<Team> getTeamsJoined() {
        return teamsJoined;
    }

    public void setTeamsJoined(ArrayList<Team> teamsJoined) {
        this.teamsJoined = teamsJoined;
    }

    public ArrayList<Team> getTeamsCreated() {
        return teamsCreated;
    }

    public void setTeamsCreated(ArrayList<Team> teamsCreated) {
        this.teamsCreated = teamsCreated;
    }

    public void manageRequests(Team team, boolean choice){

    }

    public void leaveTeam(Team team){

    }
    public void createTeam(){

    }

    public void deleteTeam(Team team){

    }
    public void manageTeam(Team team){

    }

    public ArrayList<Player> searchPlayers(){
        return null;
    }

    public void invitePlayer(Player player, Team team){

    }

    public void joinTournament(Tournament tour, Team team){

    }

    public void leaveTournament(Tournament tour, Team team){

    }

    @Override
    public String toString() {
        return "Player{" +
                "appearances=" + appearances +
                ", location='" + location + '\'' +
                ", availability=" + availability +
                ", isCaptain=" + isCaptain +
                ", favoriteSports=" + favoriteSports +
                ", teamsJoined=" + teamsJoined +
                ", teamsCreated=" + teamsCreated +
                '}';
    }
}
