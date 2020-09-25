package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random r = new Random();
        Scanner scan = new Scanner(System.in);

/*        String[][] spots = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "},
        };*/
        String[] spots = {" ", " ", " "," ", " ", " "," ", " ", " "};

        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean play = true;
        //Game loop
        while(play){//setup
            System.out.println("Do you want to be X or O?");

            //set up choice loop
            HashSet<String> choices = new HashSet<String>();
            String input = scan.next();
            String player = input;
            String computer = input.equals("X") ? "O":"X";
            String turn = computer;

            System.out.println("The Computer will go first.");

            // possibly move to ai later
            String[] startingChoices = {"1","3","7","9"};
            int start = r.nextInt(4);
            updateBoard(spots,startingChoices[start],turn);
            printBoard(spots);

            int counter = 1;
            while(counter < 9){  //Sessionloop
                turn = turn.equals(player) ? computer:player;

                if(turn.equals(computer)){ //AI
                    AIChoice(spots,turn);
                }
                else{//Player
                    playChoice(spots, turn, scan);
                    printBoard(spots);
                }
                counter++;
            }
        }
    }


    public static void playChoice(String[]spots,String turn,Scanner scan) {
        while (true) {
            System.out.println("What is your next move?");
            String input = scan.next();
            if (spots[Integer.valueOf(input)] ==" " ) {
                updateBoard(spots, input, turn);
                break;
            } else {
                System.out.println("Spot already taken! Try another!");
            }
        }
    }


    public static void AIChoice (String[] spots, String turn){
        //Check if there is a win condition
        for (int i = 0; i < spots.length ; i++) {
            if(spots[i+1].equals(turn)){


            }
        }


        //block

        //corner
        //random

    }

    public static int checkWin(String[]spots, String turn){
        //ret 0 - no win
        //ret 1 - potential
        //ret 2 - win
        //123, 147, 159, 456, 798, 258, 357, 369

    }

    public static void printBoard (String[] spots){
        System.out.printf(" %s | %s | %s\n",spots[0],spots[1],spots[2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[3],spots[4],spots[5]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[6],spots[7],spots[8]);

    }


    public static void updateBoard (String[] spots, String choice, String turn){
        switch (choice){
            case "1":
                spots[0] = turn;
                break;
            case "2":
                spots[1] = turn;
                break;
            case "3":
                spots[2] = turn;
                break;
            case "4":
                spots[3] = turn;
                break;
            case "5":
                spots[4] = turn;
                break;
            case "6":
                spots[5] = turn;
                break;
            case "7":
                spots[6] = turn;
                break;
            case "8":
                spots[7] = turn;
                break;
            case "9":
                spots[8] = turn;
                break;
        }
    }



    /*    public static void playChoice(String[][]spots,HashSet<String> choices,String turn,Scanner scan){
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
    }*/


/*    public static void printBoard (String[] spots){
        System.out.printf(" %s | %s | %s\n",spots[0][0],spots[0][1],spots[0][2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[1][0],spots[1][1],spots[1][2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[2][0],spots[2][1],spots[2][2]);
    }*/

    /*public static void updateBoard (String[][] spots, String choice, String turn){
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
    }*/
}
