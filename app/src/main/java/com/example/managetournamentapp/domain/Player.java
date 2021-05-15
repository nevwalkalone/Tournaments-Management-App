package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Player extends User {

    private String location;

    private ArrayList<Sport> sportsInterested = new ArrayList<>();

    //teams that the specific player has joined
    private ArrayList<Team> teamsJoined = new ArrayList<>();

    private ArrayList<Invitation> invitesReceived = new ArrayList<>();

    private AgeDivision ageDivision;

    //teams that the player is a captain of
    private ArrayList<Team> captainInTeams = new ArrayList<>();


    //Default Constructor
    public Player(){

    }

    public Player(String name, String surname, String phoneNumber, String email, LocalDate birthDate, Credentials credentials) {
        super(name, surname, phoneNumber, email, birthDate, credentials);
        LocalDate now = LocalDate.now();
        int diff = (int) this.getBirthDate().until(now, ChronoUnit.YEARS);
        initAgeDivision(diff);
    }


    public void initAgeDivision(int age){


        if (age<=12){
            ageDivision = AgeDivision.valueOf("K12");
        }
        else if (age<=15){
            ageDivision = AgeDivision.valueOf("K15");
        }
        else if (age<=18){
            ageDivision = AgeDivision.valueOf("K18");
        }
        else{
            ageDivision = AgeDivision.valueOf("K100");
        }
    }


    //for every player
    //after accepting a request
    //for the captain it is called in the
    //team constructor
    public void addJoinedTeam(Team team) {
        if (team == null){
            return;
        }
        teamsJoined.add(team);
        if (team.getCaptain().equals(this)){
            captainInTeams.add(team);
        }

    }

    //for every player
    public void leaveTeam(Team team) {
        if (team == null){
            return;
        }
        //this action can be completed
        //only from players
        if(team.getCaptain().equals(this)){
            return;
        }
        if (team.removePlayer(this)){
            teamsJoined.remove(team);
        }
    }


    public boolean canJoin(Team team){
        // check if player belongs in the same
        // age group
        if (!getAgeDivision().equals(team.getAgeDivision())) {
            return false;
        }
        //if the player is already in the team, no need to join again
        if (team.getPlayers().contains(this)){
            return false;
        }
        //check if this player is available for the specific sport
        if (!getSportsInterested().contains(team.getSportType())){
            return false;
        }
        return true;
    }


    //captain only
    //TODO na th doume auth
    public void deleteTeam(Team team) {
        if (team == null){
            return;
        }
        if (!team.getCaptain().equals(this)){
            return;
        }
        //tsekarei sthn ousia ola
        //ta running participations
        if(!team.hasAnyActivePart()){
            this.teamsJoined.remove(team);
            this.captainInTeams.remove(team);
            ArrayList<Player> players = team.getPlayers();
            //removing from each player the specific team
            //since it was just deleted by the captain
            for (Player player : players){
                player.getTeamsJoined().remove(team);
            }

            ArrayList<Participation> participations = team.getUndoneParticipations();
            for (Participation part : participations){

                Tournament tournament = part.getTournament();
                tournament.removeParticipation(part);
            }
        }
    }



    //TODO Check accept reject
    // tha tou rxontai sxetika aithmata mono
    // an exei valei ta antistoixa sports?
    // to xw valei twra
    //TODO thelei check
    //for every player
    public void replyToInvitation(Invitation invite , boolean accept){
        if (invite==null)
            return;
        if (invitesReceived.contains(invite))
            return;
        if (!invite.getPending())
            return;
        if (accept) {
            invite.setAccepted(true);
            invite.getTeam().addPlayer(this);
        }else{
            invite.setAccepted(false);
        }
    }


    //for every player
    public void addSportInterested(Sport sport) {
        if (sport == null){
            return;
        }
        if (sportsInterested.contains(sport)){
            return;
        }
        sportsInterested.add(sport);
    }

    //for every player
    public void removeSportInterested(Sport sport) {
        if (sport == null){
            return;
        }
        if (sportsInterested.contains(sport)){
            sportsInterested.remove(sport);
        }

    }

    public void addInvite(Invitation invite){
        if (invite==null){
            return;
        }
        invitesReceived.add(invite);
    }

    public void removeInvite(Invitation invite){
        if (invite==null){
            return;
        }
        if (!invitesReceived.contains(invite)){
            return;
        }
        invite.getTeam().addPlayer(this);
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

    public AgeDivision getAgeDivision() {
        return ageDivision;
    }

    public ArrayList<Team> getTeamsJoined() {
        return teamsJoined;
    }

    public ArrayList<Team> getCaptainInTeams() {
        return captainInTeams;
    }


    //all player's participations
    public ArrayList<Participation> getUndoneParticipations() {
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Team team : teamsJoined) {
            runningParticipations.addAll(team.getUndoneParticipations());
        }
        return runningParticipations;
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
