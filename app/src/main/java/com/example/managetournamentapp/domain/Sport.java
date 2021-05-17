package com.example.managetournamentapp.domain;


public class Sport {

    private String name;
    private int minimumPlayers;

    public Sport(String name) {
        boolean flag = checkSportName(name);
        if (flag){
            this.name = name;
            setMinPlayers(name);
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

    public void setMinPlayers( String name){
        switch(name){
            case "Volleyball3v3":
            case "Basketball3v3":
                minimumPlayers = 6;
                break;

            case "Basketball2v2":
                minimumPlayers = 4;
                break;

            case "Football5v5":
            case "Basketball5v5":
                minimumPlayers = 10;
                break;

            case "Football7v7":
                minimumPlayers = 14;
                break;

            case "Volleyball6v6":
                minimumPlayers = 12;
                break;
        }

    }

    /**
     * Change sport selection
     */
    public void changeSetup(String name){

        boolean flag = checkSportName(name);
        if (flag){
            this.name = name;
            setMinPlayers(name);
        }else{
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


    /**
     * Used for printing purposes
     */
    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", minimumPlayers=" + minimumPlayers +
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
        return true;

    }

}
