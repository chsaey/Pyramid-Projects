package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private Grid playGrid;
    private Grid shipGrid;
    private ArrayList<Ship> ships = new ArrayList<>();

    public Player(){
    }

    public Player(String name){
        this.playGrid = new Grid();
        this.shipGrid = new Grid();
        this.name = name;
    }

    public Grid getPlayGrid(){
        return this.playGrid;
    }
    public Grid getShipGrid(){
        return this.shipGrid;
    }

    public String getName(){
        return name;
    }

    public boolean addShip(Ship ship, int row, int column){

        System.out.print(ship.getClass().getSimpleName());

        return false;
    }

}
