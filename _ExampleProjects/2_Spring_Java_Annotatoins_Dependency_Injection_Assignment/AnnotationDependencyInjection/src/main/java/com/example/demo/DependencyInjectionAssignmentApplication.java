package com.example.demo;

import com.example.demo.coach.GolfCoach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DependencyInjectionAssignmentApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");


		GolfCoach golfCoach = context.getBean("golfCoach", GolfCoach.class);


		System.out.println(golfCoach.getDailyWorkout());
		System.out.println(golfCoach.getDailyFortune());


		//Close the context
		context.close();
	}

}
