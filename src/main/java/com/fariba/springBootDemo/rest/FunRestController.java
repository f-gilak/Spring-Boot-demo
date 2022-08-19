package com.fariba.springBootDemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server is :" + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 50km!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your locky dayyy!";
    }
}
