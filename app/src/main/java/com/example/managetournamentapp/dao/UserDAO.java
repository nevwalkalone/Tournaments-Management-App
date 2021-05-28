package com.example.managetournamentapp.dao;

import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.User;

public interface UserDAO {
    User verify(Credentials credentials);

}
