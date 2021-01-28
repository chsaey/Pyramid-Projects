package com.example.demo.coaches;

import com.example.demo.services.FortuneService;

public class TrackCoach implements Coach {

    private final FortuneService fortuneService;

    //Constructor Injection
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String dailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

}
