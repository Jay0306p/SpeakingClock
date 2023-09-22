package com.example.Speaking.clock.Controller;

import com.example.Speaking.clock.Service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TimeControllerTest {

    @InjectMocks
    private TimeController timeController;

    @Mock
    private TimeService timeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConvertTimeToWordsSuccess() {
        // Arrange
        String inputTime = "08:34";
        String expectedResponse = "It's eight thirty-four";
        when(timeService.convertTimeToWords(inputTime)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> response = timeController.getTimeInWords(inputTime);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testConvertTimeToWordsInvalidFormat() {
        // Arrange
        String inputTime = "08:34:00"; // Invalid format
        when(timeService.convertTimeToWords(inputTime)).thenThrow(new IllegalArgumentException("Invalid time format."));

        // Act
        ResponseEntity<String> response = timeController.getTimeInWords(inputTime);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid time format.", response.getBody());
    }
}

