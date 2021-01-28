package com.example.demo.coach;

import com.example.demo.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {
    @Autowired
    private final FortuneService fortuneService;

    @Autowired
    public GolfCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your swing";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
