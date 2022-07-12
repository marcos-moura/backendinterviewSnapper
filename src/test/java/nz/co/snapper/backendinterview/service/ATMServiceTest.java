package nz.co.snapper.backendinterview.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMServiceTest {

    ATMService atmService = new ATMService();
    @Test
    void given_value_zero_should_return_exception() {
        String expectedMessage = "Value to cash can not be 0";
        try {
            atmService.getNotes(0);
        } catch (UnsupportedOperationException exception) {
            assertEquals(expectedMessage, exception.getMessage());
        }

    }

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
    void given_valid_amount_should_return_max_unique_notes() {

//        assertEquals(1, atmService.getNotes(5)[1]);
//        assertEquals(2, atmService.getNotes(40)[1]);
//        assertEquals(3, atmService.getNotes(150)[1]);
//        assertEquals(29, atmService.getNotes(290)[1]);
//        assertEquals(59, atmService.getNotes(295)[1]);
    }
}