package nz.co.snapper.backendinterview.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ATMService {

    private static final Integer[] VALID_NOTES = {5, 10, 20, 50, 100};

    /**
     * Get the notes according to the value to be cashed.
     *
     * @param amountToCash The Value to cash.
     *
     * @return {@code int[]} The pair value containing the Note and the amount of notes.
     */
    public List<Integer> getNotes(long amountToCash) {

        if (amountToCash <= 0) {
            return new ArrayList<>();
        }

        Integer minimumNoteValue = Collections.min(Arrays.asList(VALID_NOTES));
        if (amountToCash % minimumNoteValue > 0) {
            throw new UnsupportedOperationException("Value to cash can only be multiple of 5");
        }

        List<Integer> notesToCash = new ArrayList<>();

        if (amountToCash == VALID_NOTES[0] || amountToCash == VALID_NOTES[1]) {
            notesToCash.add((int) amountToCash);
            return notesToCash;
        }

        int notesValueSum = Arrays.stream(VALID_NOTES)
                .mapToInt(Integer::intValue)
                .sum();

        Map<Integer, Integer> minimalNotesMap;

        if (amountToCash > notesValueSum){

            notesToCash.addAll(Arrays.asList(VALID_NOTES));
            minimalNotesMap = getMinimalNotes(VALID_NOTES.length - 1, amountToCash - notesValueSum, new HashMap<>());
            notesToCash.addAll(getNotesAsList(minimalNotesMap));
        } else {

            long remainingValue = amountToCash;
            for (Integer validNote : VALID_NOTES) {

                if (remainingValue >= validNote) {

                    notesToCash.add(validNote);
                    remainingValue = remainingValue - validNote;

                } else if (remainingValue > 0) {

                    minimalNotesMap = getMinimalNotes(VALID_NOTES.length - 1, remainingValue, new HashMap<>());
                    List<Integer> notesList = getNotesAsList(minimalNotesMap);
                    notesToCash.addAll(notesList);
                    break;
                } else {
                    break;
                }
            }
        }

        // Easy to count notes
        notesToCash.sort(Collections.reverseOrder());
        return notesToCash;

    }

    /**
     * Return a list of notes given a map with number of notes per notes value.
     */
    private List<Integer> getNotesAsList(Map<Integer, Integer> minimalNotesMap) {
        List<Integer> notesList =  new ArrayList<>();
        minimalNotesMap.forEach((noteValue, quantityOfNotes) -> {
            for (int j = 0; j < quantityOfNotes; j++){
                notesList.add(noteValue);
            }
        });
        return notesList;
    }

    /**
     * Create a Map with as few notes as possible.
     */
    private Map<Integer, Integer> getMinimalNotes(int noteIndex, long amountToCash, Map<Integer, Integer> notesToCash) {

        long notes = amountToCash / VALID_NOTES[noteIndex];
        long remainingValue = amountToCash % VALID_NOTES[noteIndex];

        if (notes > 0) {
            notesToCash.put(VALID_NOTES[noteIndex], (int) notes);
        }

        if (remainingValue > 0) {
            getMinimalNotes(--noteIndex, remainingValue, notesToCash);
        }

        return notesToCash;
    }
}

