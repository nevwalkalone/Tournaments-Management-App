package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import com.example.managetournamentapp.domain.Player;

public interface OrganizerDAO {

    Player verify(Credentials credentials);

    void save(Organizer entity);

    void delete(Organizer entity);

    void deleteAll();

    Organizer find(String name);

}
