package com.company;

import java.util.Scanner;

public class Board {
    private Player player1;
    private Player player2;

    public Board() {

    }

    public void setPlayer1(String name) {

        player1 = new Player(name);
    }

    public void setPlayer2(String name) {
        player2 = new Player(name);

    }

    public Player getPlayer1() {
        return player1;

    }

    public Player getPlayer2() {

        return player2;
    }

    public String namePhase() {
        //Scanner scan = new Scanner(System.in);
        String test = "test";
        while (true) {
            try {
                //return (scan.next());
                return test;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void shipPhase(Player player) {
        System.out.println(player.getName() + ", please enter the coordinates for your ships....");
        player.getShipGrid().printGrid();
        initializeShip(player, new Carrier());
        initializeShip(player, new Battleship());
        initializeShip(player, new Destroyer());
        initializeShip(player, new Submarine());
        initializeShip(player, new PatrolBoat());
    }

    public boolean battlePhase(Player attacker, Player defender) {
        Scanner scan = new Scanner(System.in);
        attacker.getPlayGrid().printGrid();
        while (true) {
            try {
                System.out.print("\n" + attacker.getName() + ", please choose a coordinate to attack: ");
                //String input = scan.next();
                String input = "(1,1)";
                Coordinate coordinate = new Coordinate(input);
                if (evaluateCoordinate(coordinate, attacker.getPlayGrid())) {
                    attacker.fire(coordinate, attacker.getPlayGrid(), defender.getShipGrid(), defender);
                    attacker.getPlayGrid().printGrid();
                    return checkWin(attacker, defender);
                }
                throw new Exception("You've hit this spot or it's out of bounds. Try again.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkWin(Player attacker, Player defender) {
        if (defender.getShips().isEmpty()) {
            System.out.println("All of " + defender.getName() + "'s ships have been sunk! " + attacker.getName() + " Has won!");
            return true;
        }
        return false;
    }

    public void initializeShip(Player player, Ship ship) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter starting point for your " + ship.getClass().getSimpleName() + "...");
                //String input = scan.next();
                String input = "(1,1)";
                Coordinate coordinate = new Coordinate(input);
                if (evaluateCoordinate(coordinate, player.getShipGrid())) {

                    System.out.println("What direction? Vertical (v) or Horizontal (h)?");
                    //input = scan.next();
                    input = "h";
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

    public boolean evaluateCoordinate(Coordinate coordinate, Grid grid) {
        if (coordinate.isValid() && grid.checkGrid(coordinate)) {
            return true;
        }
        return false;
    }

    public boolean canPlaceShip(Coordinate coordinate, String direction, Player player, int length) {
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

    public void placeShip(Coordinate coordinate, String direction, Player player, Ship ship) {
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
