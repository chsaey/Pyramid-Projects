package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Ship {
    protected int length;
    protected HashSet<Coordinate> coordinates;
    protected char shipID;

    public boolean hasCoordinate(String coordinate) { // check if ship is on the coordinate
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

    public void setLength(int length) {
        this.length = length;
    }

}
