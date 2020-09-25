package com.company;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scan = new Scanner(System.in);


        String[] spots = {" ", " ", " "," ", " ", " "," ", " ", " "};

        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean play = true;
        //Game loop
        while(play){//setup

            System.out.println("Do you want to be X or O?");
            String input = scan.next();
            String player = input;
            String computer = input.equals("X") ? "O":"X";
            String turn = player;

            System.out.println("The Computer will go first.");
            int counter = 0;
            while(counter < 9){  //Sessionloop
                turn = turn.equals(player) ? computer:player;

                if(turn.equals(computer)){ //AI
                    AIChoice(spots,computer,player);
                }
                else{//Player
                    playChoice(spots, player, scan);
                }
                printBoard(spots);
                counter++;
            }
        }
    }


    public static void playChoice(String[]spots,String player,Scanner scan) {
        while (true) {
            System.out.println("What is your next move?");
            String input = scan.next();
            if (spots[Integer.parseInt(input)-1].equals(" ")) {
                updateBoard(spots, input, player);
                break;
            } else {
                System.out.println("Spot already taken! Try another!");
            }
        }
    }


    public static boolean AIChoice (String[] spots, String computer, String player){
        //Check if there is a win condition
        boolean block = false;
        int blockSpot =0;

        //check if can win and block spots
        for (int i = 0; i < spots.length ; i++) {

            if( spots[i].equals(" ")){
                if(checkBoard(spots,i,computer)){
                    updateBoard(spots,String.valueOf(i+1),computer);
                    return true;
                }
                if(checkBoard(spots,i,player)){
                    block =true;
                    blockSpot=i+1;
                }
            }
        }

        if(block){
            updateBoard(spots,String.valueOf(blockSpot),computer);
        } else{
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
            return other.get(r.nextInt(corner.size())) + 1;
        }
    }




    public static void printBoard (String[] spots){
        System.out.printf(" %s | %s | %s\n",spots[0],spots[1],spots[2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[3],spots[4],spots[5]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s\n",spots[6],spots[7],spots[8]);

    }


    public static boolean checkBoard(String[] spots, int i, String turn){

        switch(i){
            case 0:
                if ((spots[1].equals(turn) && spots[2].equals(turn)) || (spots[3].equals(turn) && spots[6].equals(turn)) || (spots[4].equals(turn) && spots[8].equals(turn)) ) {

                    return true;
                }
                break;

            case 1:
                if ((spots[0].equals(turn) && spots[2].equals(turn)) || (spots[4].equals(turn) && spots[7].equals(turn)) ) {

                    return true;

                }
                break;
            case 2:
                if ((spots[0].equals(turn) && spots[1].equals(turn) )|| (spots[5].equals(turn) && spots[8].equals(turn)) || (spots[4].equals(turn) && spots[6].equals(turn)) ) {

                    return true;

                }
                break;
            case 3:
                if ((spots[0].equals(turn) && spots[6].equals(turn)) || (spots[4].equals(turn) && spots[5].equals(turn) )) {

                    return true;
                }
                break;
            case 4:
                if ((spots[0].equals(turn) && spots[8].equals(turn)) || (spots[2].equals(turn) && spots[6].equals(turn))|| (spots[1].equals(turn) && spots[7].equals(turn)) || (spots[3].equals(turn) && spots[5].equals(turn)) ) {

                    return true;
                }
                break;
            case 5:
                if ((spots[3].equals(turn) && spots[4].equals(turn)) || (spots[2].equals(turn) && spots[8].equals(turn) )) {

                    return true;
                }
                break;
            case 6:
                if ((spots[0].equals(turn) && spots[3].equals(turn)) || (spots[7].equals(turn) && spots[8].equals(turn)) || (spots[4].equals(turn) && spots[2].equals(turn)) ) {

                    return true;
                }
                break;
            case 7:
                if ((spots[4].equals(turn) && spots[1].equals(turn)) || (spots[6].equals(turn) && spots[8].equals(turn))  ) {

                    return true;
                }
                break;
            case 8:
                if ((spots[5].equals(turn) && spots[2].equals(turn)) || (spots[7].equals(turn) && spots[6].equals(turn)) ) {

                    return true;
                }
                break;
        }
        return false;
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
