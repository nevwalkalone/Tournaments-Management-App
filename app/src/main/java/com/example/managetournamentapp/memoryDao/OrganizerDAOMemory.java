package com.example.managetournamentapp.memoryDao;

import com.example.managetournamentapp.dao.OrganizerDAO;
import com.example.managetournamentapp.domain.Credentials;
import com.example.managetournamentapp.domain.Organizer;
import java.util.ArrayList;

/**
 * Developed for the purposes of University Lesson "Software Engineering" at AUEB
 * -Athens University of Economics and Business
 */

public class OrganizerDAOMemory implements OrganizerDAO {
    protected static ArrayList<Organizer> entities = new ArrayList<>();

    /**
     * Verifies user, checks if credentials are ok.
     * @param credentials Credentials of User.
     * @return true if credentials are verified.
     */
    @Override
    public boolean verify(Credentials credentials) {
        boolean valid = false;
        if(exist(credentials))
            valid = true;
        return valid;
    }

    /**
     * Saves a specific organizer.
     * @param entity Organizer to be saved.
     */
    @Override
    public void save(Organizer entity) {
        entities.add(entity);
    }

    /**
     * Deletes a specific organizer.
     * @param entity Organizer to be deleted.
     */
    @Override
    public void delete(Organizer entity) {
        entities.remove(entity);
    }

    /**
     * Deletes all organizers.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Finds a specific organizer.
     * @param title Title of the organizer.
     * @return Organizer with the title specified.
     */
    @Override
    public Organizer findByTitle(String title) {
        for (Organizer o : entities) {
            if (o.getTitle().equals(title))
                return o;
        }
        return null;
    }

    /**
     * Finds a specific organizer.
     * @param credentials credentials of the organizer.
     * @return Organizer with the credentials specified.
     */
    @Override
    public Organizer findByCredentials(Credentials credentials) {
        for (Organizer o : entities) {
            if (o.getCredentials().equals(credentials))
                return o;
        }
        return null;
    }

    /**
     * Check if the user who tries to login exists in DAO.
     * @param credentials User input credentials
     * @return true if User exists in DAO
     */
    @Override
    public boolean exist(Credentials credentials) {
        for (Organizer o : entities) {
            if (o.getCredentials().equals(credentials))
                return true;
        }
        return false;
    }

    /**
     * Finds all organizers.
     * @return All organizers.
     */
    @Override
    public ArrayList<Organizer> findAll() {
        ArrayList<Organizer> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }
}
