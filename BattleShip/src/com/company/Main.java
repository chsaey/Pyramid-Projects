package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        System.out.println("Welcome to Battleship Multiplayer");
        boolean play = true;
        while (play) {//game loop
            Scanner scan = new Scanner(System.in);
            Board board = new Board();

            //name phase
            System.out.println("Enter Player 1's name: ");
            board.setPlayer1(board.namePhase());
            System.out.println("Enter Player 2's name: ");
            board.setPlayer2(board.namePhase());

            //ship phase
            System.out.println("\n--------Player's 1 setup--------");
            board.shipPhase(board.getPlayer1());
            System.out.println("\n\n--------Player's 2 setup--------");
            board.shipPhase(board.getPlayer2());

            //Battle phase & session loop
            System.out.println("\n\n--------Battle phase--------\n");
            while (true) {
                System.out.println("\n--------Player 1's turn--------\n");
                if (board.battlePhase(board.getPlayer1(), board.getPlayer2()))
                    break;
                System.out.println("\n--------Player 2's turn--------\n");
                if (board.battlePhase(board.getPlayer2(), board.getPlayer1()))
                    break;
            }//end session loop

            while (true) {//replay
                System.out.print("\nPlay again? (y or n): ");
                try {
                    String input = scan.next();

                    if (input.toLowerCase().equals("y")) {
                        break;
                    }
                    if (input.toLowerCase().equals("n")) {
                        play = false;
                        break;
                    }
                    throw new Exception("Invalid option. Expected y or n!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }//end replay loop
        }//end game loop
    }

}
