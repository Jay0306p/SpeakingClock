package com.example.Speaking.clock.Service;

import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.time.format.*;

@Service
public class TimeService {

    public String convertTimeToWords(String time) {
        try {
            // Split the time into hours and minutes
            String[] parts = time.split(":");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid time format. Expected format: HH:mm");
            }

            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);

            // Define arrays for words representing numbers
            String[] numbers = {
                    "zero", "one", "two", "three", "four", "five",
                    "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                    "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
            };

            String[] tens = {
                    "", "", "twenty", "thirty", "forty", "fifty"
            };

            // Convert hours to words
            String hourWords = "";
            if (hours == 0) {
                hourWords = "Midnight";
            } else if (hours == 12) {
                hourWords = "Noon";
            } else if (hours < 20) {
                hourWords = numbers[hours];
            } else {
                hourWords = tens[hours / 10] + " " + numbers[hours % 10];
            }

            // Convert minutes to words
            String minuteWords = "";
            if (minutes == 0) {
                minuteWords = "o'clock";
            } else if (minutes < 20) {
                minuteWords = numbers[minutes];
            } else {
                minuteWords = tens[minutes / 10] + " " + numbers[minutes % 10];
            }

            // Construct the final time-to-words representation
            String result = "It's " + hourWords + " " + minuteWords;

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time format. Hours and minutes must be numeric.", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while converting the time to words.", e);
        }
    }

}

