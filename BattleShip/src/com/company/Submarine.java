package com.company;

import java.util.HashSet;

public class Submarine extends Ship {

    public Submarine(){
        this.length = 3;
        this.coordinates = new HashSet<>();
        this.shipID = 'S';
    }
}
