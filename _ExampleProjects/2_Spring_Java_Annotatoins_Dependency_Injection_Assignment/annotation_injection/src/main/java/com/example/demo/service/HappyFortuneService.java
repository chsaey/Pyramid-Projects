package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HappyFortuneService implements FortuneService{
    String[] fortunes = {"Today is your lucky day!!!", "You will get injured next match...", "You will be kicked off the team..."};
    @Override
    public String getFortune() {
        Random random = new Random();
        return fortunes[random.nextInt(3)];
    }
}
