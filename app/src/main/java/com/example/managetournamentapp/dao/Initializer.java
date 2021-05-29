package com.example.managetournamentapp.dao;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData(){

        //todo fill
    }

    public abstract GameDAO getGameDAO();

    public abstract GroupDAO getGroupDAO();

    public abstract InvitationDAO getInvitationDAO();

    public abstract OrganizerDAO getOrganizerDAO();

    public abstract ParticipationDAO getParticipationDAO();

    public abstract PlayerDAO getPlayerDAO();

    public abstract RoundDAO getRoundDAO();

    public abstract TeamDAO getTeamDAO();

    public abstract TournamentDAO getTournamentDAO();



}
