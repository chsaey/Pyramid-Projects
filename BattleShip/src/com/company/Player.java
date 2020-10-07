package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Player {
    private String name;
    private Grid playGrid;
    private Grid shipGrid;
    //private ArrayList<Ship> ships = new ArrayList<>();
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

    public HashMap<Character, HashSet<Coordinate>> getShips(){
        return ships;

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
}
