package com.example.Speaking.clock.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeServiceTest {

    @InjectMocks
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

        // Act
        String result = timeService.convertTimeToWords(inputTime);

        // Assert
        assertEquals(expectedResponse, result);
    }
}
