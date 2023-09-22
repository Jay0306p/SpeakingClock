package com.example.Speaking.clock.Controller;

import com.example.Speaking.clock.Service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/{inputTime}")
    public ResponseEntity<String> getTimeInWords(@PathVariable String inputTime) {
        try {
            String timeInWords = timeService.convertTimeToWords(inputTime);
            return ResponseEntity.ok(timeInWords);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid time format: " + e.getMessage());
        }
    }
}

