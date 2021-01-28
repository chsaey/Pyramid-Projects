package com.example.demo.coaches;

import com.example.demo.services.FortuneService;

public class BasketballCoach implements Coach {
    private FortuneService fortuneService;
    private String city;
    private int wins;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
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
        return "Run 2 miles";
    }
}
