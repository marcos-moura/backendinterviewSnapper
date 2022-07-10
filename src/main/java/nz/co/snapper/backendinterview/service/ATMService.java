package nz.co.snapper.backendinterview.service;

import org.springframework.stereotype.Service;

@Service
public class ATMService {

    private static final int[] VALID_NOTES = {100, 50, 20, 10, 5};
    private static final int MIN_NOTE_VALUE = 5;

    /**
     * Get the notes according to the value to be cashed.
     *
     * @param amountToCash The Value to cash.
     *
     * @return {@code int[]} The pair value containing the Note and the amount of notes.
     */
    public int[] getNotes(int amountToCash) {

        if (amountToCash == 0) {
            throw new UnsupportedOperationException("Value to cash can not be 0");
        }

        if (amountToCash % MIN_NOTE_VALUE > 0) {
            throw new UnsupportedOperationException("Value to cash can only be multiple of 5");
        }

        int[] notesToCash = new int[2];
        return getUniqueNotes(0, amountToCash, notesToCash);
    }

    /**
     *
     * Calculates the number of notes to obtain as many as unique notes as possible.
     * It iterates through valid notes Array from the biggest value to small value until get the
     * first remaining value equal 0 to return.
     *
     */
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
