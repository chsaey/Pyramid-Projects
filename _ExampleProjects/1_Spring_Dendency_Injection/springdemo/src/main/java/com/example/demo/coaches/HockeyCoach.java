package com.example.demo.coaches;

import com.example.demo.services.FortuneService;

public class HockeyCoach implements Coach {

    private FortuneService fortuneService;

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public HockeyCoach() {

    }

    @Override
    public String dailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "500 lunges";
    }
}
