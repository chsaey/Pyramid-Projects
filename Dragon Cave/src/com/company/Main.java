package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
		String input = "";
	System.out.println("You are in a land full of dragons. In front of you");
	System.out.println("you see two caves. In one cave, the dragon is friendly");
	System.out.println("and will share his treasure with you. The other dragon");
	System.out.println("is greedy and hungry and will eat you on sight.");


	while(!input.equals("1")&&!input.equals("2")){
		System.out.print("Which cave will you go into? (1 or 2):\n\n");
		input = scan.next();
		System.out.print("\n\n");
	}

	switch(input){
		case "1":
			System.out.println("You approach the cave...");
			System.out.println("It is dark and spooky...");
			System.out.println("A large dragon jumps out in front of you! He opens hi jaws and...");
			System.out.println("Gobbles you down in one bite!");
			break;
		case "2":
			System.out.println("Yo approach the cave...");
			System.out.println("It is initially dark and musty...");
			System.out.println("You see a shimmering of light in the distance...");
			System.out.println("Your curiosity moves you faster towards what looks like a mountain... ");
			System.out.println("A GIGANTIC DRAGON, swoops down from the ceiling and...");
			System.out.println("Offers you a part of its treasure!");
			break;


	}
    }
}
