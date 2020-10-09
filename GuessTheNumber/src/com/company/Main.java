package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean play = true;

        while (play) {
            play = true;
            Random r = new Random();
            int counter = 0;
            int num = r.nextInt(20) + 1;
            String name;

            System.out.println("\nHello!, What is your name?\n");

            while (true) {
                try {
                    name = scan.next();
                    System.out.println("\nWell, " + name + ", I am thinking of a number between 1 and 20.");
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid, try again");
                }
            }

            while (true) {//Guess loop
                System.out.println("Take a guess.\n");

                String guess;
                int guessNum;
                try {
                    guess = scan.next();
                    guessNum = Integer.parseInt(guess);
                } catch (Exception e) {
                    System.out.println("\nInvalid! Enter a number please...");
                    continue;
                }
                counter++;
                if (guessNum > num) {
                    System.out.println("\nYour guess is too high!");
                } else if (guessNum < num) {
                    System.out.println("\nYour guess is too low!");
                } else {
                    System.out.println("Good job, " + name + "! You guessed my number in " + counter + " guesses!");
                    break; //break inner loop
                }
            }//end guess loop

            while (true) {//reset loop
                System.out.println("Would you like to play again? (y or n)\n");
                try {
                    String reset = scan.next();
                    if (reset.toLowerCase().equals("n")) {
                        play = false;
                        break;
                    } else if (reset.toLowerCase().equals("y")) {
                        break;
                    }
                    throw new Exception("Please enter a y or n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }// end reset loop

        }// end play loop

    }
}
