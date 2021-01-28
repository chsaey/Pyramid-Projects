package com.example.demo.coaches;

import com.example.demo.services.FortuneService;

public class WrestlingCoach implements Coach {

    private FortuneService fortuneService;
    private String school;
    private String teamSize;

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    public WrestlingCoach() {

    }

    @Override
    public String dailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "1 hour of sparring";
    }
}
