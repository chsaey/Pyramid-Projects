package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        System.out.println("Welcome to Battleship Multiplayer");

        try{ // Setup playerName
            System.out.println("Enter Player 1 name: ");
            board.setPlayer1(scan.next());
            System.out.println("Enter Player 2 name: ");
            board.setPlayer2(scan.next());
        }     catch(Exception e){
            System.out.println("Error. Try again");
        }

        //Set up ships
        System.out.println(board.getPlayer1().getName()+ ", please enter the coordinates for your ships....");
        board.getPlayer1().getShipGrid().printGrid();

        System.out.println("Enter the coordinates for the carrier. Please use format \"(row,column)\": ");
        //get input and check if it's valid
        System.out.println("Place horizontally or vertically? (h or v): ");
        //check if horizontal or vertical
        Coordinate c = new Coordinate("(-1,-2)");
        System.out.println(c.getRow());
        System.out.println(c.getColumn());
        //check all indexes from the start point to length are in bounds and do not already have a ship


    }

    public boolean evaluateCoordinate(String coordinate, Player player){
        int row;
        int column;

        if(coordinate.matches("^\\([1-9],[1-9]\\)$")){
            row = Integer.parseInt(coordinate.substring(1,2));
            column = Integer.parseInt(coordinate.substring(3,4));
            return player.getShipGrid().checkGrid(row,column);}

        return false;
    }


    public boolean placeShip(Player player){

        return false;
    }

}
