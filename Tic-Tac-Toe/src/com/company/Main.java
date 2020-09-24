package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        HashSet<String> choices = new HashSet<String>();
        String[][] spots = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "},
        };

        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean play = true;
        //Game loop
        while(play){//setup
            System.out.println("Do you want to be X or O?");

            //set up choice loop
            String input = scan.next();
            String player = scan.next();
            String computer = input.equals("X") ? "O":"X";
            String turn = computer;


            System.out.println("The Computer will go first.");

            String[] startingChoices = {"1","3","7","9"};
            int start = r.nextInt(4);
            choices.add(startingChoices[start]);
            updateBoard(spots,startingChoices[start],turn);



            while(true){  //Sessionloop
                printBoard(spots);
                turn = turn.equals("X") ? "O":"X";
                if(turn.equals("X")){}

                //if computers turn
                ///

                //human turn

            }
        }
    }

    public static void playChoice(String[][]spots,HashSet<String> choices,String turn,Scanner scan){
        while(true){
            System.out.println("What is your next move?");
            String input = scan.next();
            if(choices.add(input)){
                updateBoard(spots, input, turn);
                break;
            } else{
                System.out.println("Spot already taken! Try another!");
            }
        }
    }

    public static void AIChoice (String[][]spots, String turn){
        //win
        //block
        //corner
        //random

    }

    public static void checkWin(String[][]spots, String turn){

    }


    public static void printBoard (String[][] spots){
        System.out.printf(" %s | %s | %s\n",spots[0][0],spots[0][1],spots[0][2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[1][0],spots[1][1],spots[1][2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[2][0],spots[2][1],spots[2][2]);
    }
    public static void updateBoard (String[][] spots, String choice, String turn){
        switch (choice){
            case "1":
                spots[0][0] = turn;
                break;
            case "2":
                spots[0][1] = turn;
                break;
            case "3":
                spots[0][2] = turn;
                break;
            case "4":
                spots[1][0] = turn;
                break;
            case "5":
                spots[1][1] = turn;
                break;
            case "6":
                spots[1][2] = turn;
                break;
            case "7":
                spots[2][0] = turn;
                break;
            case "8":
                spots[2][1] = turn;
                break;
            case "9":
                spots[2][2] = turn;
                break;
        }
    }
}
