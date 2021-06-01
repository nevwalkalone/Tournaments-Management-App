package com.example.managetournamentapp.view.Organizer.ManageTournaments;

import com.example.managetournamentapp.util.Quadruple;

import java.util.ArrayList;

public interface ManageTournamentsView{
    /**
     * Μεταφερει τον χρήστη στο activity BookDetailsActivity
     * όταν γίνει click πάνω στο βιβλίο με id uid.
     * @param uid Το μοναδικό id του βιβλίου
     */
    void clickItem(int uid);

    /**
     * Μεταφερει τον χρήστη στο activity ManageItemsActivity
     * όταν γίνει click πάνω στο βιβλίο με id uid.
     * @param uid Το μοναδικό id του βιβλίου
     */
    void clickItemList(int uid);

    /**
     * Ξεκινάει το activity AddEditBookActivity
     */
    void startAddNew();

    /**
     * Φορτώνει την λίστα με τα βιβλία
     * @param input Η λίστα που θα φορτώσει
     */
    void loadSource(ArrayList<Quadruple> input);

    /**
     * Θέτει το όνομα της σελίδας.
     * @param value το όνομα της σελίδας
     */
    void setPageName(String value);

    /**
     * Εμφανίζει ένα Toast.
     * @param value Το περιεχόμενο που θα εμφανιστεί
     */
    void showToast(String value);

    /**
     * Αποφασίζει με ποιο με τρόπο θα φορτώσει τα
     * αντικείμενα.
     * @return Τον τρόπο που θα φορτώσει τα αντικείμενα
     */
    boolean shouldLoadItemsOnClick();

    /**
     * Επιστρέφει το id του συγγραφέα.
     * @return Το id του συγγραφέα
     */
    Integer getAttachedAuthorID();

    /**
     * Επιστρέφει το id του εκδότη.
     * @return Το id του εκδότη
     */
    Integer getAttachedPublisherID();
}
