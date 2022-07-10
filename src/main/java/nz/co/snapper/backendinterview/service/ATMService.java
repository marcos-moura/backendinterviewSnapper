package nz.co.snapper.backendinterview.service;

import org.springframework.stereotype.Service;

@Service
public class ATMService {

    private static final int[] VALID_NOTES = {100, 50, 20, 10, 5};

    /**
     * Get notes considering the amount of notes must contain as many unique notes as possible.
     *
     * @param amountToCash The Value to cash.
     *
     * @return {@code int[]} The pair value containing the Note and the amount of notes.
     */
    public int[] getNotes(int amountToCash) {

        int[] notesToCash = new int[2];
        return getUniqueNotes(0, amountToCash, notesToCash);
    }

    private int[] getUniqueNotes(int noteIndex, int amountToCash, int[] notesToCash) {

        int notes = amountToCash / VALID_NOTES[noteIndex];
        int remainingValue = amountToCash % VALID_NOTES[noteIndex] ;

        if (remainingValue == 0) {
            notesToCash[0] = VALID_NOTES[noteIndex];
            notesToCash[1] = notes;
        } else {
            getUniqueNotes(++noteIndex, amountToCash, notesToCash);
        }

        return notesToCash;
    }
}
