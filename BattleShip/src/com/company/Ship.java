package com.company;


import java.util.Arrays;
import java.util.HashSet;

public abstract class Ship {
    protected int length;
    protected HashSet<Coordinate> coordinates;
    protected char shipID;

    public boolean hasCoordinate(String coordinate) {
        if (coordinates.contains(coordinate))
            return true;
        return false;
    }

    public HashSet<Coordinate> getCoordinates() {
        return this.coordinates;
    }

    public void addCoordinate(Coordinate coordinate){
         this.coordinates.add(coordinate);
    }

    public int getLength() {
        return this.length;
    }

    public char getShipID(){
        return this.shipID;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ":\nLength: " + this.length + ":\nShip ID: " + this.shipID + ":\nCoordinates: " + Arrays.toString(coordinates.toArray());
    }


}
