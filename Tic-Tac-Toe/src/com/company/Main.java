package com.company;

import jdk.jshell.spi.ExecutionControlProvider;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean play = true;
        while (play) { //Game loop
            //setup
            String[] spots = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
            String input;
            while (true) {//choose loop
                try {
                    System.out.println("Do you want to be X or O?");
                    input = scan.next().toUpperCase();
                    if (input.equals("X") || input.equals("O")) {
                        break;
                    }
                    throw new Exception("...Please enter X or O...");
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }//end choose loop

            String player = input;
            String computer = input.equals("X") ? "O" : "X";

            //set initially to player as it swaps in loop.
            String turn = player;

            System.out.println("The Computer will go first.");
            int counter = 0;
            while (counter < 9) {  //Sessionloop
                turn = turn.equals(player) ? computer : player;

                if (turn.equals(computer)) { //AI
                    if (AIChoice(spots, computer, player)) {
                        System.out.println("Computer has won! Too bad!");
                        printBoard(spots);
                        break;
                    }
                    printBoard(spots);
                } else {//Player
                    if (playerChoice(spots, player, scan)) {
                        System.out.println("You won! Congratulations!");
                        printBoard(spots);
                        break;
                    }
                }
                counter++;
            }

            if (counter == 9) {
                System.out.println("\nIts a tie!");
                printBoard(spots);
            }
            //play again?
            while (true) {
                try{
                    System.out.println("\nPlay again? (yes or no)");
                    String replay = scan.next().toLowerCase();
                    if (replay.equals("no")) {
                        play = false;
                        break;
                    } else if (replay.equals("yes")) {
                        break;
                    }
                    throw new Exception("Expected yes or no...");
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        }
    }


    public static boolean playerChoice(String[] spots, String player, Scanner scan) {
        while (true) {
            try {
                System.out.println("What is your next move? Enter a number 1-9.");
                String input = scan.next();
                if (input.length() == 1 && input.matches("[1-9]")) {
                    if (spots[Integer.parseInt(input) - 1].equals(" ")) {
                        updateBoard(spots, input, player);
                        if (checkBoard(spots, Integer.parseInt(input) - 1, player)) {
                            return true;
                        }
                        break;
                    } else {
                        throw new Exception("Spot already taken! Try another!");
                    }
                } else {
                    throw new Exception("Invalid input. Try again.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        return false;
    }





    public static boolean AIChoice(String[] spots, String computer, String player) {
        //Check if there is a win condition
        boolean block = false;
        int blockSpot = 0;

        //check if can win and block spots
        for (int i = 0; i < spots.length; i++) {

            if (spots[i].equals(" ")) {
                if (checkBoard(spots, i, computer)) {
                    updateBoard(spots, String.valueOf(i + 1), computer);
                    return true;
                }
                if (checkBoard(spots, i, player)) {
                    block = true;
                    blockSpot = i + 1;
                }
            }
        }

        if (block) {
            updateBoard(spots, String.valueOf(blockSpot), computer);
        } else {
            updateBoard(spots, String.valueOf(pickSpot(spots)), computer);
        }
        return false;
    }

    public static int pickSpot(String[] spots) {
        Random r = new Random();
        ArrayList<Integer> corner = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        for (int i = 0; i < spots.length; i++) {
            if (spots[i].equals(" ")) {
                switch (i) {
                    case 0, 2, 6, 8:
                        corner.add(i);
                    default:
                        other.add(i);
                }
            }
        }
        if (corner.size() > 0) {
            return corner.get(r.nextInt(corner.size())) + 1;
        } else {
            return other.get(r.nextInt(other.size())) + 1;
        }
    }


    public static void printBoard(String[] spots) {
        System.out.printf(" %s | %s | %s\n", spots[0], spots[1], spots[2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n", spots[3], spots[4], spots[5]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n", spots[6], spots[7], spots[8]);

    }

    // Used to check win conditions
    public static boolean checkBoard(String[] spots, int i, String turn) {

        switch (i) {
            case 0:
                if ((spots[1].equals(turn) && spots[2].equals(turn)) || (spots[3].equals(turn) && spots[6].equals(turn)) || (spots[4].equals(turn) && spots[8].equals(turn))) {

                    return true;
                }
                break;

            case 1:
                if ((spots[0].equals(turn) && spots[2].equals(turn)) || (spots[4].equals(turn) && spots[7].equals(turn))) {

                    return true;

                }
                break;
            case 2:
                if ((spots[0].equals(turn) && spots[1].equals(turn)) || (spots[5].equals(turn) && spots[8].equals(turn)) || (spots[4].equals(turn) && spots[6].equals(turn))) {

                    return true;

                }
                break;
            case 3:
                if ((spots[0].equals(turn) && spots[6].equals(turn)) || (spots[4].equals(turn) && spots[5].equals(turn))) {

                    return true;
                }
                break;
            case 4:
                if ((spots[0].equals(turn) && spots[8].equals(turn)) || (spots[2].equals(turn) && spots[6].equals(turn)) || (spots[1].equals(turn) && spots[7].equals(turn)) || (spots[3].equals(turn) && spots[5].equals(turn))) {

                    return true;
                }
                break;
            case 5:
                if ((spots[3].equals(turn) && spots[4].equals(turn)) || (spots[2].equals(turn) && spots[8].equals(turn))) {

                    return true;
                }
                break;
            case 6:
                if ((spots[0].equals(turn) && spots[3].equals(turn)) || (spots[7].equals(turn) && spots[8].equals(turn)) || (spots[4].equals(turn) && spots[2].equals(turn))) {

                    return true;
                }
                break;
            case 7:
                if ((spots[4].equals(turn) && spots[1].equals(turn)) || (spots[6].equals(turn) && spots[8].equals(turn))) {

                    return true;
                }
                break;
            case 8:
                if ((spots[5].equals(turn) && spots[2].equals(turn)) || (spots[7].equals(turn) && spots[6].equals(turn)) || (spots[0].equals(turn) && spots[4].equals(turn))) {

                    return true;
                }
                break;
        }
        return false;
    }

    //Place X or O onto board
    public static void updateBoard(String[] spots, String choice, String turn) {
        spots[Integer.parseInt(choice) - 1] = turn;
    }
}
