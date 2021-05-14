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


    private AgeDivision ageDivision;

    //teams that the player is a captain of
    private ArrayList<Team> captainInTeams = new ArrayList<>();


    //Default Constructor
    public Player(){

    }

    public Player(String name, String surname, String phoneNumber, String email, LocalDate birthDate, Credentials credentials) {
        super(name, surname, phoneNumber, email, birthDate, credentials);
        LocalDate now = LocalDate.now();
        long diff = this.getBirthDate().until(now, ChronoUnit.DAYS);
        initAgeDivision(diff);
    }


    public void initAgeDivision(long daysSinceBirthDate){

        int age = (int) daysSinceBirthDate/365;

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


    //captain only
    public void invitePlayer(Team team, Player player){

        if(player == null || team == null || player.equals(this)){
            return;
        }
        //check if the one who invites is the captain
        if (!team.getCaptain().equals(this)){
            return;
        }
        // check if player belongs in the same
        // age group
        if (!player.getAgeDivision().equals(team.getAgeDivision())) {
            return;
        }
        //if the player is already in the team, no need to join again
        if (team.getPlayers().contains(player)){
            return;
        }

        //check if this player is available for the specific sport
        if (!player.getSportsInterested().contains(team.getSportType())){
            return;
        }

        //invite from the team comes to the player
        if (player.manageRequest(team, true)){
            team.addPlayer(player);
        }

    }

    //captain only
    public void joinTournament(Tournament tournament, Team team) {
        if (team == null || tournament == null){
            return;
        }
        if (!team.getCaptain().equals(this)){
            return;
        }
        Participation participation = new Participation(tournament,team);
        team.addParticipation(participation);
    }

    //captain only
    public void leaveTournament(Tournament tournament, Team team) {
        if (team == null || tournament == null){
            return;
        }
        if (!team.getCaptain().equals(this)){
            return;
        }
        ArrayList<Participation> tempParts = team.getParticipations();
        for (Participation part : tempParts){
            if(part.getTournament().equals(tournament)){
                team.removeParticipation(part);
                break;
            }
        }

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

            ArrayList<Participation> participations = team.getParticipations();
            for (Participation part : participations){
                Tournament tournament = part.getTournament();
                tournament.removeParticipation(part);
            }
        }
    }


    public void deleteJoinedTeam(Team team){
        if (team == null){
            return;
        }
        if (!teamsJoined.contains(team)){
            return;
        }
        if (team.hasAnyActivePart()){
            return;
        }
        this.teamsJoined.remove(team);
        if (team.getCaptain().equals(this)){
            captainInTeams.remove(team);
            for (Player player : team.getPlayers()){
                player.getTeamsJoined().remove(team);
            }
            for (Participation part : team.getParticipations()){ //TODO GETRUNNINGPART..
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
    public boolean manageRequest(Team team, boolean flagTest){
        System.out.println("Request made from team: "+team.getName());
        if (flagTest) {
            System.out.println("Accepted");
            return true;
        }
        System.out.println("Rejected");
        return false;
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


  /*  //TODO check player age
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
    }*/

   /* public boolean alreadyParticipates (Tournament tournament){
        for (Participation playerPart : getRunningParticipations()) {
            if (tournament.isSimultaneous(playerPart))
                return false;
        }
        return true;
    }*/


    //all player's participations
    public ArrayList<Participation> getRunningParticipations() {
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Team team : teamsJoined) {
            runningParticipations.addAll(team.getRunningParticipations());
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

    public static void main (String [] args){
        Credentials credentials = new Credentials();
        LocalDate birthDate = LocalDate.of(1990, Month.APRIL,4);
        Player player = new Player ("g","","","",birthDate,credentials);
    }
}
