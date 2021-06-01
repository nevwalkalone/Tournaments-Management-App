package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Invitation;

import java.time.LocalDate;
import java.util.ArrayList;

public interface InvitationDAO {

    /**
     * Saves a specific invitation.
     * @param entity Invitation to be saved.
     */
    void save(Invitation entity);

    // TODO
    void find(String teamName, LocalDate dateSent);

    /**
     * Finds all invitations.
     * @return All invitations.
     */
    ArrayList<Invitation> findAll();

    /**
     * Deletes a specific invitation.
     * @param entity Invitation to be deleted
     */
    void delete(Invitation entity);

    /**
     * Deletes all invitations.
     */
    void deleteAll();


}
