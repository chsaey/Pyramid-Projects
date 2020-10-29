package com.company;

import java.util.HashSet;

public class Battleship extends Ship {

    public Battleship(){
        this.length = 4;
        this.coordinates = new HashSet<>();
        this.shipID = 'B';
    }

}
