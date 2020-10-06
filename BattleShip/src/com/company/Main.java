package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        System.out.println("Welcome to Battleship Multiplayer");
        boolean play = true;
        while (play ){//game loop
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        //setup phase
        try { //names
            System.out.println("Enter Player 1 name: ");
            board.setPlayer1(scan.next());
            System.out.println("Enter Player 2 name: ");
            board.setPlayer2(scan.next());
        } catch (Exception e) {
            System.out.println("Error. Try again");
        }
        //ships
        System.out.println(board.getPlayer1().getName() + ", please enter the coordinates for your ships....");
        board.getPlayer1().getShipGrid().printGrid();
        initializeShip(board.getPlayer1(), new Carrier());
        initializeShip(board.getPlayer1(), new Battleship());

        System.out.println("\n" + board.getPlayer2().getName() + ", please enter the coordinates for your ships....");
        board.getPlayer2().getShipGrid().printGrid();
        initializeShip(board.getPlayer2(), new Carrier());
        initializeShip(board.getPlayer2(), new Battleship());

        //Battle phase

            

        }//end game loop
    }

    public static void initializeShip(Player player, Ship ship){
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter starting point for your " + ship.getClass().getSimpleName() + "...");
                String input = scan.next();
                Coordinate coordinate = new Coordinate(input);
                if (evaluateCoordinate(coordinate, player.getShipGrid())) {

                    System.out.println("What direction? Vertical (v) or Horizontal (h)?");
                    input = scan.next();
                    if (input.toLowerCase().equals("v") || input.toLowerCase().equals("h") && canPlaceShip(coordinate, input, player, ship.length)) {
                        placeShip(coordinate, input, player, ship);
                        player.getShipGrid().printGrid();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again\n");

            }
        }
    }

    public static boolean evaluateCoordinate(Coordinate coordinate, Grid grid) {

        if (coordinate.getRow() >= 1 && coordinate.getRow() <= 9 && coordinate.getColumn() >= 1 && coordinate.getColumn() <= 9 && grid.checkGrid(coordinate)) {
            return true;
        }
        return false;
    }


    public static boolean canPlaceShip(Coordinate coordinate, String direction, Player player, int length) {
        Coordinate temp = new Coordinate(coordinate.getRow(), coordinate.getColumn());
        if (direction.equals("h")) {
            for (int i = 0; i < length; i++) {

                if (evaluateCoordinate(temp, player.getShipGrid()) == false) return false;
                temp.setColumn(temp.getColumn() + 1);
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (evaluateCoordinate(temp, player.getShipGrid()) == false) return false;
                temp.setColumn(temp.getRow() + 1);
            }
        }
        return true;
    }

    public static void placeShip(Coordinate coordinate, String direction, Player player, Ship ship) {
        for (int i = 0; i < ship.getLength(); i++) {
            ship.addCoordinate(new Coordinate(coordinate.getRow(), coordinate.getColumn()));
            if (direction.equals("h")) {
                coordinate.setColumn(coordinate.getColumn() + 1);
            } else {
                coordinate.setRow(coordinate.getRow() + 1);
            }
        }
        player.addShip(ship);
    }

}
