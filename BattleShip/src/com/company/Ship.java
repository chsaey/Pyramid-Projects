package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Ship {
    private int length;
    private HashSet<String> coordinates = new HashSet<>();
    //private HashMap<Integer, ArrayList<Integer>> coordinates = new HashMap<>();

    public boolean hasCoordinate(String coordinate) {
        if (coordinates.contains(coordinate))
            return true;
        return false;
    }

    public HashSet<String> getCoordinates() {
        return coordinates;
    }

    public void addCoordinates(String coordinate){
         coordinates.add(coordinate);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
