package com.company;

import java.sql.SQLOutput;
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
            board.setPlayer1(namePhase());
            System.out.println("Enter Player 2's name: ");
            board.setPlayer2(namePhase());

            //ship phase
            System.out.println("\n--------Player's 1 setup--------");
            shipPhase(board.getPlayer1());
            System.out.println("\n\n--------Player's 2 setup--------");
            shipPhase(board.getPlayer2());

            //Battle phase & session loop
            System.out.println("\n\n--------Battle phase--------\n");
            while (true) {
                System.out.println("\n--------Player 1's turn--------\n");
                if (battlePhase(board.getPlayer1(), board.getPlayer2()))
                    break;
                System.out.println("\n--------Player 2's turn--------\n");
                if (battlePhase(board.getPlayer2(), board.getPlayer1()))
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

    public static String namePhase() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return (scan.next());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void shipPhase(Player player) {
        System.out.println(player.getName() + ", please enter the coordinates for your ships....");
        player.getShipGrid().printGrid();
        initializeShip(player, new Carrier());
        initializeShip(player, new Battleship());
        initializeShip(player, new Destroyer());
        initializeShip(player, new Submarine());
        initializeShip(player, new PatrolBoat());
    }
    public static boolean battlePhase(Player attacker, Player defender) {
        Scanner scan = new Scanner(System.in);
        attacker.getPlayGrid().printGrid();
        while (true) {
            try {
                System.out.print("\n" + attacker.getName() + ", please choose a coordinate to attack: ");
                String input = scan.next();
                Coordinate coordinate = new Coordinate(input);
                if (evaluateCoordinate(coordinate, attacker.getPlayGrid())) {
                    fire(coordinate, attacker.getPlayGrid(), defender.getShipGrid(), defender);
                    attacker.getPlayGrid().printGrid();
                    return checkWin(attacker, defender);

                }
                throw new Exception("You've hit this spot or it's out of bounds. Try again.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static boolean checkWin(Player attacker, Player defender) {
        if (defender.getShips().isEmpty()) {
            System.out.println("All of " + defender.getName() + "'s ships have been sunk! " + attacker.getName() + " Has won!");
            return true;
        }
        return false;
    }

    public static void fire(Coordinate coordinate, Grid playGrid, Grid shipGrid, Player defender) {

        char hit = shipGrid.getPointOnGrid(coordinate);
        switch (hit) {
            case '~':
                System.out.println("<You missed!>");
                playGrid.setPointOnGrid(coordinate, 'M');
                break;
            default:
                System.out.println("<Hit!>");
                playGrid.setPointOnGrid(coordinate, 'X');
                String result = defender.hitShip(hit, coordinate);
                if (!result.isEmpty()) {
                    System.out.println("You sunk " + defender.getName() + "'s " + result + "!");
                }
                break;
        }
    }

    public static void initializeShip(Player player, Ship ship) {
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
                System.out.println("Another ship is there or out of bounds. Try again\n");

            }
        }
    }

    public static boolean evaluateCoordinate(Coordinate coordinate, Grid grid) {

        if (coordinate.isValid() && grid.checkGrid(coordinate)) {
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
