package com.example.demo;

import com.example.demo.coaches.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        TrackCoach trackCoach = context.getBean("myTrackCoach", TrackCoach.class);
        FootballCoach footBallCoach = context.getBean("myFootballCoach", FootballCoach.class);
        BaseballCoach baseballCoach = context.getBean("myBaseballCoach", BaseballCoach.class);
        WrestlingCoach wrestlingCoach = context.getBean("myWrestlingCoach", WrestlingCoach.class);
        BasketballCoach basketballCoach = context.getBean("myBasketballCoach", BasketballCoach.class);

        System.out.println("\nTrack Coach...");
        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.dailyFortune());

        System.out.println("\nFootBall Coach...");
        System.out.println(footBallCoach.getDailyWorkout());
        System.out.println(footBallCoach.dailyFortune());

        System.out.println("\nBaseball Coach...");
        System.out.println("Team: " + baseballCoach.getTeam());
        System.out.println("Email: " + baseballCoach.getEmailAddress());
        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(baseballCoach.dailyFortune());

        System.out.println("\nWrestling Coach...");
        System.out.println("School: " + wrestlingCoach.getSchool());
        System.out.println("Team Size: " + wrestlingCoach.getTeamSize());
        System.out.println(wrestlingCoach.getDailyWorkout());
        System.out.println(wrestlingCoach.dailyFortune());

        System.out.println("\nBasketball Coach...");
        System.out.println("City: " + basketballCoach.getCity());
        System.out.println("Wins: " + basketballCoach.getWins());
        System.out.println(basketballCoach.getDailyWorkout());
        System.out.println(baseballCoach.dailyFortune());

        context.close();


    }

}
