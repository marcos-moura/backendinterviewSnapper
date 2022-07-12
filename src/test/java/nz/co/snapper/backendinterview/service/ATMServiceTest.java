package nz.co.snapper.backendinterview.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ATMServiceTest {

    ATMService atmService = new ATMService();

    @Test
    void given_value_not_multiple_of_5_should_return_exception() {
        String expectedMessage = "Value to cash can only be multiple of 5";
        try {
            atmService.getNotes(17);
        } catch (UnsupportedOperationException exception) {
            assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test
    void given_zero_or_negative_value_should_return_empty_list() {

        assertTrue(atmService.getNotes(0).isEmpty());
        assertTrue(atmService.getNotes(-50).isEmpty());

    }

    @Test
    void given_valid_amount_request_should_sum_of_notes_be_equal() {

        int expectedValue = 90;
        List<Integer> notes = atmService.getNotes(90);

        int notesValueSum = notes.stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(expectedValue, notesValueSum);

    }

    @Test
    void given_valid_amount_185_should_return_only_unique_notes() {

        Integer[] NOTES = {5, 10, 20, 50, 100};
        List<Integer> expectedNotes = Arrays.asList(NOTES);

        List<Integer> notesCashed = atmService.getNotes(185);
        assertTrue(expectedNotes.containsAll(notesCashed));
    }
}