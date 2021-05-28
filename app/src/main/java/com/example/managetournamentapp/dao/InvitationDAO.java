package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Invitation;

import java.time.LocalDate;

public interface InvitationDAO {

    void save(Invitation entity);

    void delete(Invitation entity);

    // todo
    void find(String teamName, LocalDate dateSent);

}
