# Περιγραφή του Πεδίου Προβλήματος-R1

Το παρόν έγγραφο αφορά την εργασία του μαθήματος Τεχνολογίας Λογισμικού η οποία σχετίζεται με την ανάπτυξη λογισμικού. Στο συγκεκριμένο παραδοτέο (R1) κληθήκαμε να αναλύσουμε τις απαιτήσεις καθώς και να δώσουμε διαγραμματική αναπαράσταση της εφαρμογής, με ένα διάγραμμα περιπτώσεων χρήσης, ακολουθώντας το πρότυπο UML. Παρακάτω τα ζητούμενα αυτά αναλύονται πλήρως.


## Υπηρεσία Διοργάνωσης Ερασιτεχνικών Πρωταθλημάτων 

Πρόκειται για την δημιουργία μιας ηλεκτρονικής πλατφόρμας για την οργάνωση ερασιτεχνικών πρωταθλημάτων μπάσκετ, ποδοσφαίρου κτλ. Ο διοργανωτής του πρωταθλήματος θα επιλέγει άθλημα, ηλικιακή κατηγορία και χρονικό διάστημα διεξαγωγής των αγώνων. Οι ενδιαφερόμενοι θα έχουν την δυνατότητα δήλωσης της ομάδας τους στο πρωτάθλημα της επιλογής τους. Ο ελάχιστος αριθμός ατόμων για την δημιουργία μιας ομάδας εξαρτάται από το άθλημα (πχ. 5 για το μπάσκετ, 11 για ποδόσφαιρο,κτλ). Στην περίπτωση που δεν συμπληρώνεται ο απαιτούμενος αριθμός ατόμων για την δημιουργία μιας ομάδας, θα υπάρχει δυνατότητα εύρεσης ατόμων από μία συγκεκριμένη βάση δεδομένων που θα περιέχει άτομα τα οποία ψάχνουν ομάδα. Επιπλέον χρήστες που θα αλληλεπιδρούν με το σύστημα, θα είναι οι διαχειριστές του συστήματος.

### Πίνακας με τον αριθμό απαίτησης και την περιγραφή της:


Αριθμός Απαίτησης |  Περιγραφή
------------ | --------------
1 | Το σύστημα θα εμφανίζει δύο επιλογές- εγγραφής για παίκτες και διοργανωτές και σύνδεσης για τους παραπάνω και επιπλέον για τους διαχειριστές.
2 | Το σύστημα κατά τη διαδικασία εγγραφής ζητάει τα στοιχεία που χρειάζονται για ταυτοποίηση.
3 | Το σύστημα ελέγχει αν είναι έγκυρα τα στοιχεία που εισήχθησαν και στέλνει mail επιβεβαίωσης (verification mail).
4 | Το σύστημα εναλλακτικά, θα παρέχει την πρόσβαση και σε μη εγγεγραμμένους χρήστες (δηλαδή σύνδεση ως guest) σε συγκεριμένες λειτουργίες (όπως περιήγηση).
5 | To σύστημα θα επιτρέπει στο διοργανωτή να δημιουργεί πρωτάθλημα με την επιλογή συγκεκριμένων στοιχείων (άθλημα, ηλικιακή κατηγορία, χρονικό διάστημα διεξαγωγής αγώνων κ.α.)
6 | Το σύστημα με βάση το άθλημα και τον τύπο διοργάνωσης που έχει επιλεγεί από το διοργανωτή έχει προκαθορισμενα προαπαιτούμενα (ηλικές, αριθμός παικτών κ.α) και ταυτόχρονα θα ελέγχει και το κατά πόσο τηρούνται αυτά.
7 | Το σύστημα δίνει τη δυνατότητα για κάθε παίκτη ο οποίος δεν έχει ομάδα, να δηλώσει ότι είναι διαθεσιμος.
8 | Το σύστημα δίνει τη δυνατότητα στον αντιπρόσωπο να δημιουργεί ομάδα, στέλνοντας αίτημα για συμμετοχή σε άλλους εγγεγραμένους χρήστες.
9 | Το σύστημα θα δίνει τη δυνατότητα σε κάθε παίκτη να απαντήσει θετικά μόνο σε ένα αίτημα ομάδας για μία συγκεκριμένη διοργάνωση
10 | Το σύστημα ενημερώνει τον παίκτη για σημαντικά γεγόνοτα (συμμετοχή σε ομάδα, έναρξη-λήξη πρωταθλήματος κ.α.).
11 | Το σύστημα δίνει τη δυνατότητα στον αντιπρόσωπο της ομάδας να αναζητήσει πρωτάθλημα για συγκέκριμενο άθλημα και να δηλώσει συμμετοχή με αναφορά και στους αντίστοιχους παίκτες που θα λάβουν μέρος.
12 | Σε περίπτωση που δεν συμπληρώνεται ο απαιτούμενος αριθμός παικτών, όπως προαναφέρεται παραπάνω, το σύστημα θα παρέχει τη δυνατότητα στον αντιπρόσωπο να βρει κάποιον παίκτη από ένα σύνολο διαθέσιμων παικτών.
13 | Το σύστημα εμφανίζει τα αιτήματα συμμετοχής από όλες τις ομάδες στο διοργανωτή, τα οποία αυτός με τη σειρά του επιβεβαιώνει ή απορρίπτει (ανάλογα με κριτήρια που θα αναλυθούν περαιτέρω).
14 | Το σύστημα επιτρέπει στο διοργανωτή να δημιουργεί γύρους και προγράμματα αγώνων για κάθε γύρο.
15 | Το σύστημα επιλέγει αυτόματα τους αντιπάλους κάθε αγώνα και τις ομάδες που περνάνε στον επόμενο γύρο.
16 | Το σύστημα επιτρέπει σε εγγεγραμμένους και μη χρήστες να έχουν πρόσβαση στο πρόγραμμα των αγώνων και στα αποτελέσματα κάθε γύρου.
17 | Το σύστημα θα δίνει τη δυνατότητα στον διοργανωτή να ανεβάζει για τη συγκεκριμένη διοργάνωση λεπτομερή γεγονότα του κάθε αγώνα (πόντοι κάθε παίκτη, χρόνος συμμετοχης κ.α) τα οποία αναπαράγουν τα στατιστικά της κάθε διοργάνωσης.
18 | Το σύστημα πρέπει να διατηρεί τα στατιστικά της κάθε διοργάνωσης και μετά το πέρας της.



### Επισκόπηση διαγράμματος περιπτώσεων χρήσης

![Εναλλακτικό κείμενο](/docs/markdown/uml/requirements/use_case_R1.png)