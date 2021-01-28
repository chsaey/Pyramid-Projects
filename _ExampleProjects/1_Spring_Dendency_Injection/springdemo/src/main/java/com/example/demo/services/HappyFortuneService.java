package com.example.demo.services;

import com.example.demo.services.FortuneService;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    String[] fortunes = {"You will succeed if you follow the ABCs of coding...", "You will get injured next match...", "You will be kicked off the team..."};
    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(3)];
    }
}
