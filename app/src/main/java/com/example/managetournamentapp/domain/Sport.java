package com.example.managetournamentapp.domain;


public class Sport {

    private String name;
    private int minimumPlayers, gameDuration;

    public Sport(String name, int minimumPlayers, int gameDuration) {
        boolean flag = checkSportName(name);
        if (flag){
           flag = checkMinPlayers(minimumPlayers,name);
        }
        if (flag) {
            flag = checkGameDuration(gameDuration,name);
        }

        if (flag){
            this.name = name;
            this.minimumPlayers = minimumPlayers;
            this.gameDuration = gameDuration;
        }
        else{
            System.out.println("Wrong settings for the specific sport type selection.");
        }
    }

    public boolean checkSportName(String name) {
        for (TournamentType tt : TournamentType.values()) {
            if (tt.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMinPlayers(int minimumPlayers, String name){
        switch(name){
            case "Volleyball3v3":
            case "Basketball3v3":
                if (minimumPlayers == 6){
                    this.minimumPlayers =6;
                    return true;
                }
            case "Basketball2v2":
                if (minimumPlayers == 4){
                    return true;
                }
            case "Football5v5":
            case "Basketball5v5":
                if (minimumPlayers == 10){
                    return true;
                }
            case "Football7v7":
                if (minimumPlayers == 14){
                    return true;
                }
            case "Volleyball6v6":
                if (minimumPlayers == 12) {
                    return true;
            }
        }
        return false;
    }

    public boolean checkGameDuration(int gameDuration, String name){
        switch(name){
            case "Volleyball3v3":
            case "Volleyball6v6":
                if (gameDuration == 0 ){
                    return true;
                }
            case "Basketball2v2":
            case "Basketball3v3":
                if (gameDuration == 20){
                    return true;
                }

            case "Basketball5v5":
                if (gameDuration == 40){
                    return true;
                }
            case "Football5v5":
            case "Football7v7":
                if (gameDuration == 70){
                    return true;
                }
        }
        return false;
    }

    /**
     * Change sport selection
     */
    public void changeSetup(String name, int minimumPlayers, int gameDuration){

        boolean flag = checkSportName(name);
        if (flag){
            flag = checkMinPlayers(minimumPlayers,name);
        }
        if (flag) {
            flag = checkGameDuration(gameDuration,name);
        }

        if (flag){
            this.name = name;
            this.minimumPlayers = minimumPlayers;
            this.gameDuration = gameDuration;
        }
        else{
            System.out.println("Wrong settings for the specific sport type selection.");
        }
    }

    //NO SETTERS NEEDED


    //GETTERS

    public String getName() {
        return name;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    /**
     * Used for printing purposes
     */
    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", minimumPlayers=" + minimumPlayers +
                ", gameDuration=" + gameDuration +
                '}';
    }

    /**
     * Checking if the fields between
     * the two objects are equal
     */
    public boolean equals(Object other){

        if (other == null) {
            return false;
        }
        if (!(other instanceof Sport)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        Sport check = (Sport) other;

        if (!(name == null ? check.getName() == null : name.equals( check.getName()))){
            return false;
        }

        if (!(minimumPlayers == check.getMinimumPlayers())){
            return false;
        }

        if (!(gameDuration == check.getGameDuration())) {
            return false;
        }

        return true;

    }

}
