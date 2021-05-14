package com.example.managetournamentapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;


public class Team {

    private String name, colors;
    private Sport sportType;
    private AgeDivision ageDivision;
    private Player captain;
    private  ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Participation> participations = new ArrayList<>();

    public Team(){

    }

    public Team(String name, Sport sportType, AgeDivision ageDivision, Player captain) {
        this.name = name;
        this.sportType = sportType;
        this.ageDivision = ageDivision;
        this.captain = captain;

        //add captain to the team
        addPlayer(captain);

    }

    public ArrayList<Player> getPlayers() {

        return players;
    }


    //checks are made on player class
    public void addPlayer(Player player) {
        if (player == null){
            return;
        }
        if (players.contains(player)){
            return;
        }
        if (hasAnyActivePart())
            return;
        if (ageDivision.equals(player.getAgeDivision())){
            return ;
        }

        players.add(player);
        //add team to the player
        player.addJoinedTeam(this);
    }

    public boolean removePlayer(Player player){
        if (!hasAnyActivePart()){
            players.remove(player);
            return true;
        }
        return false;
    }



    //removes player from the team
    public boolean hasAnyActivePart(){

        //check if there is any running participation
        boolean flag = false;
        for (Participation part : participations){
            if (!canLeaveTournament(part)){
                flag = true;
                break;
            }
        }
        //player can be successfully removed
        //because there is no active tournament
        //for his team
        return flag;
    }

//TODO CHECK
    public boolean hasAnyActivePart2(){
        for (Participation participation : participations){
            if (participation.isCurrent()){
                return true;
            }
        }
        return false;
    }


    public void addParticipation(Participation participation) {
        if (participation == null ){
            return;
        }
        if (participations.contains(participation)){
            return;
        }
        // TODO if( hasAnyActivePart()  ) return

        if (canParticipate(participation)){
            participations.add(participation);
            participation.getTournament().addParticipation(participation);
        }
    }

    //we need the tournament to remove the appropriate participation
    //linked with the tournament
    public void removeParticipation(Participation participation) {
        if (canLeaveTournament(participation)){
            //successfully left the tournament
            participations.remove(participation);

            //remove the specific participation from the tournament
            participation.getTournament().removeParticipation(participation);
        }
    }

    private boolean canLeaveTournament(Participation participation){
        LocalDate now = LocalDate.now();

        if(participation.getTournament().getStartDate().compareTo(now)<0
                && participation.getTournament().getFinishDate().compareTo(now)>0){
            return false;
        }
        return true;
    }

    //if all criterias are met, then this team
    //can join the specific tournament TODO CHECK
    private boolean canParticipate(Participation participation) {
        Tournament tournToJoin = participation.getTournament();

        if (!getAgeDivision().equals(tournToJoin.getAgeDivision())) {
            return false;
        }

        if (!tournToJoin.getSportType().equals(sportType)) {
            return false;
        }

        if (tournToJoin.isFull()){
            return false;
        }

        if (players.size() < ( sportType.getMinimumPlayers()/2)){
            return false;
        }

        //if there is a player that participates in the specific tournament
        //with another team, then this team can't join the tournament
        for (Player player : players){
            for (Participation playerPart : player.getRunningParticipations()) {
                if (playerPart.inSameTournament(participation)){
                    return false;
                }
            }
        }

        //if the date of the specific participation interferes with
        //dates of other participations, then this team can't join the tournament
        LocalDate startDate = participation.getStartDate();
        LocalDate finishDate = participation.getFinishDate();

        for (Participation part : participations){
            if ( participation.isSimultaneous(part) )
                return  false;
        }
        return true;
    }


    public ArrayList<Participation> getParticipations() {
        return participations;
    }

    public ArrayList<Participation> getRunningParticipations() {
        ArrayList<Participation> runningParticipations = new ArrayList<>();
        for (Participation p : participations) {
            if (!p.isPast())
                runningParticipations.add(p);
        }
        return runningParticipations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Sport getSportType() {
        return sportType;
    }

    public void setSportType(Sport sportType) {
        this.sportType = sportType;
    }

    public AgeDivision getAgeDivision() {
        return ageDivision;
    }

    public void setAgeDivision(AgeDivision ageDivision) {
        this.ageDivision = ageDivision;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", colors='" + colors + '\'' +
                ", sportType=" + sportType +
                ", ageDivision=" + ageDivision +
                ", captain=" + captain +
                ", playersNumber=" +
                '}';
    }


    public boolean equals(Object other) {

        boolean equal = false;
        if (other instanceof Team) {
            Team otherTeam = (Team) other;
            if (name.equals(otherTeam.name) && sportType.equals(otherTeam.sportType))
                equal = true;
        }
        return equal;
    }

}
