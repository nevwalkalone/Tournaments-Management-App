# **Περιγραφή του Πεδίου Προβλήματος-R1**

Το παρόν έγγραφο αφορά την εργασία του μαθήματος Τεχνολογίας Λογισμικού η οποία σχετίζεται με την ανάπτυξη λογισμικού. Στο συγκεκριμένο παραδοτέο (R1) κληθήκαμε να αναλύσουμε τις απαιτήσεις καθώς και να δώσουμε διαγραμματική αναπαράσταση της εφαρμογής, με ένα διάγραμμα περιπτώσεων χρήσης, ακολουθώντας το πρότυπο UML. Παρακάτω παρουσιάζονται τα ζητούμενα αυτά.


## **Υπηρεσία Διοργάνωσης Ερασιτεχνικών Πρωταθλημάτων** 

Πρόκειται για την δημιουργία μιας ηλεκτρονικής πλατφόρμας για την οργάνωση ερασιτεχνικών πρωταθλημάτων μπάσκετ, ποδοσφαίρου κτλ. Ο διοργανωτής του πρωταθλήματος θα επιλέγει άθλημα, ηλικιακή κατηγορία και χρονικό διάστημα διεξαγωγής των αγώνων. Οι ενδιαφερόμενοι θα έχουν την δυνατότητα δήλωσης της ομάδας τους στο πρωτάθλημα της επιλογής τους. Ο ελάχιστος αριθμός ατόμων για την δημιουργία μιας ομάδας εξαρτάται από το άθλημα (πχ. 5 για το μπάσκετ, 11 για ποδόσφαιρο,κτλ). Στην περίπτωση που δεν συμπληρώνεται ο απαιτούμενος αριθμός ατόμων για την δημιουργία μιας ομάδας, θα υπάρχει δυνατότητα εύρεσης ατόμων από μία συγκεκριμένη βάση δεδομένων που θα περιέχει άτομα τα οποία ψάχνουν ομάδα.

### **Πίνακας με τον αριθμό απαίτησης και την περιγραφή της:**


Αριθμός Απαίτησης |  Περιγραφή
------------ | --------------
1 | Το σύστημα θα εμφανίζει δύο επιλογές, εγγραφή και σύνδεση, στο κάθε χρήστη.
2 | Το σύστημα κατά τη διαδικασία εγγραφής ζητάει τα στοιχεία που χρειάζονται για ταυτοποίηση.
3 | Το σύστημα ελέγχει αν είναι έγκυρα τα στοιχεία που εισήχθησαν και στέλνει mail επιβεβαίωσης (verification mail).
4 | Το σύστημα θα παρέχει την πρόσβαση σε όλους τους χρήστες σε συγκεριμένες λειτουργίες (όπως περιήγηση).
5 | To σύστημα θα επιτρέπει στο διοργανωτή να διεξάγει πρωτάθλημα με την επιλογή συγκεκριμένων στοιχείων (άθλημα, ηλικιακή κατηγορία, χρονικό διάστημα διεξαγωγής αγώνων κ.α.)
6 | Το σύστημα, ανάλογα με το άθλημα που έχει επιλεχθεί και την ηλικιακή κατηγορία, θα ρυθμίζει τα προαπαιτούμενα (ηλικές, αριθμός παικτών κ.α) της διοργάνωσης και ταυτόχρονα θα ελέγχει και το κατά πόσο τηρούνται αυτά.
7 | Το σύστημα δίνει τη δυνατότητα σε κάθε παίκτη, ο οποίος δεν έχει ομάδα, να δηλώσει ότι είναι διαθεσιμος.
8 | Το σύστημα δίνει τη δυνατότητα στον αντιπρόσωπο να δημιουργεί ομάδα, στέλνοντας αίτημα για συμμετοχή σε άλλους παίκτες.
9 | Το σύστημα θα δίνει τη δυνατότητα σε κάθε παίκτη να απαντήσει θετικά μόνο σε ένα αίτημα ομάδας για μία συγκεκριμένη διοργάνωση.
10 | Το σύστημα ενημερώνει τον παίκτη για σημαντικά γεγόνοτα (συμμετοχή σε ομάδα, έναρξη-λήξη πρωταθλήματος κ.α.).
11 | Το σύστημα δίνει τη δυνατότητα στον αντιπρόσωπο της ομάδας να αναζητήσει πρωτάθλημα για συγκέκριμενο άθλημα και να δηλώσει συμμετοχή με αναφορά και στους αντίστοιχους παίκτες που θα λάβουν μέρος.
12 | Σε περίπτωση που δεν συμπληρώνεται ο απαιτούμενος αριθμός παικτών, όπως προαναφέρεται παραπάνω, το σύστημα θα παρέχει τη δυνατότητα στον αντιπρόσωπο να βρει κάποιον παίκτη από ένα σύνολο διαθέσιμων παικτών.
13 | Το σύστημα εμφανίζει τα αιτήματα συμμετοχής από όλες τις ομάδες στο διοργανωτή, τα οποία αυτός με τη σειρά του επιβεβαιώνει ή απορρίπτει (ανάλογα με κριτήρια που θα αναλυθούν περαιτέρω).
14 | Το σύστημα επιτρέπει στο διοργανωτή να δημιουργεί/επεξεργάζεται γύρους και προγράμματα αγώνων για κάθε διοργάνωση.
15 | Το σύστημα επιλέγει αυτόματα τους αντιπάλους κάθε αγώνα και τις ομάδες που περνάνε στον επόμενο γύρο.
16 | Το σύστημα επιτρέπει στους χρήστες να έχουν πρόσβαση στο πρόγραμμα των αγώνων και στα αποτελέσματα κάθε γύρου.
17 | Το σύστημα θα δίνει τη δυνατότητα στον διοργανωτή να ανεβάζει για τη συγκεκριμένη διοργάνωση τα αποτελέσματα των αγώνων για κάθε γύρο.
18 | Το σύστημα πρέπει να διατηρεί τα αποτελέσματα της κάθε διοργάνωσης και μετά το πέρας της.



### **Πίνακας Περιπτώσεων Χρήσης:**

Περιπτώση Χρήσης |  Περιγραφή
------------ | --------------
**ΠΧ1. Προβολή πληροφοριών διοργάνωσης** | Ο χρήστης εγγεγραμένος ή μη θα έχει την δυνατότητα να παρακολουθεί τις γενικότερες πληροφορίες για κάποια διοργάνωση ( αγώνες, βαθμολογίες κλπ.)
**ΠΧ2. Διαχείριση Λογαριασμού Χρήστη** | Ο χρήστης μπορεί δημιουργήσει ή να επεξεργαστεί τον λογαριασμό του.
**ΠΧ3. Ταυτοποίηση Χρήστη** | Ο εγγεγραμμένος χρήστης οφείλει να ταυτοποιείται σε κάθε του σύνδεση στην πλατφόρμα του συστήματος.
**ΠΧ4. Διαχείριση Διοργάνωσης** | Ο διοργανωτής ορίζει τα στοιχεία της διοργάνωσης, πρίν ή μετα τη δημιουργία της.
**ΠΧ5. Διεξαγωγή Διοργάνωσης** | Ο διοργανωτής επιβλέπει και καθοδηγεί τη εξέλιξη της διοργάνωσης.
**ΠΧ6. Αποδοχή αιτήματος ομάδας** | Ο Παίκτης μπορεί να αποδεχτεί αιτήματα για συμμετοχή σε ομάδα, που γίνονται από τους αντιπρόσωπους.
**ΠΧ7. Διαχείριση διαθεσιμότητας** | Ο Παίκτης μπορεί να δηλώσει ότι ενδιαφέρεται να συμμετάσχει σε μία ομάδα για μία διοργάνωση. Αυτή η δήλωση, εγγράφεται στον κατάλογο των παικτών που είναι προς αναζήτηση συμπαικτών.
**ΠΧ8. Δήλωση συμμετοχής σε διοργάνωση** | Κάθε αντιπρόσωπος και μόνος αυτός μπορεί να δηλώσει συμμετοχή για μία ομάδα σε μία διοργάνωση.
**ΠΧ9. Διαχείριση ομάδας** | Κάθε Αντιπρόσωπος έχει την δυνατότητα να δημιουργήσει την δικιά του ομάδα για συμμετοχή σε μία διοργάνωση.
**ΠΧ10. Αναζήτηση παικτών** | Σε περίπτωση που υπάρχουν ελλείψεις παικτών από μία ομάδα, ο Αντιπρόσωπος της μπορεί να αναζητήσει παίκτες από τον κατάλογο παικτών που δήλωσαν ενδιαφέρον συμμετοχής σε ομάδα.


### **Επισκόπηση διαγράμματος περιπτώσεων χρήσης**

![Εναλλακτικό κείμενο](/docs/markdown/uml/requirements/use_case_R2.png)
