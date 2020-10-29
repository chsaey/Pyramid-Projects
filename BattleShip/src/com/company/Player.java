package com.company;


import java.util.HashMap;
import java.util.HashSet;

public class Player {
    private String name;
    private Grid playGrid;
    private Grid shipGrid;
    private HashMap<Character, HashSet<Coordinate>> ships = new HashMap<>();


    public Player() {
    }

    public Player(String name) {
        this.playGrid = new Grid();
        this.shipGrid = new Grid();
        this.name = name;
    }

    public String hitShip(char shipID, Coordinate coordinate) {
        HashSet<Coordinate> temp = ships.get(shipID);

        for (Coordinate c : temp
        ) {
            if (c.isEqual(coordinate)) {
                temp.remove(c);
                ships.replace(shipID, temp);
                break;
            }
        }

        if (ships.get(shipID).isEmpty()) {
            ships.remove(shipID);
            switch (shipID) {
                case 'C':
                    return "Carrier";
                case 'B':
                    return "Battleship";
                case 'D':
                    return "Destroyer";
                case 'S':
                    return "Submarine";
                case 'P':
                    return "Patrol Boat";
            }
        }
        return "";
    }

    public void fire(Coordinate coordinate, Grid playGrid, Grid shipGrid, Player defender) {

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

    public HashMap<Character, HashSet<Coordinate>> getShips() { return ships; }

    public void clearShips(){
        this.ships = new HashMap<>();
    }

    public Grid getPlayGrid() {
        return this.playGrid;
    }

    public Grid getShipGrid() {
        return this.shipGrid;
    }

    public String getName() {
        return name;
    }

    public void addShip(Ship ship) {
        ships.putIfAbsent(ship.getShipID(), ship.getCoordinates());
        for (Coordinate c : ship.getCoordinates()
        ) {
            this.shipGrid.placeOnGrid(c, ship.getShipID());
        }
    }
    @Override
    public String toString(){
        return name +" "+ships.keySet();

    }
}
