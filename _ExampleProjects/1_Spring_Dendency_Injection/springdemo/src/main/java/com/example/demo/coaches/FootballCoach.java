package com.example.demo.coaches;

import com.example.demo.services.FortuneService;

public class FootballCoach implements Coach {
    private FortuneService fortuneService;

    public FootballCoach() {

    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String dailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Time for 2 a days.";
    }
}
