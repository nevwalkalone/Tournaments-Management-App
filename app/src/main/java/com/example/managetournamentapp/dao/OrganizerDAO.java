package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Organizer;

public interface OrganizerDAO extends UserDAO{

    void save(Organizer entity);

    void delete(Organizer entity);

    Organizer find(String name);

}
