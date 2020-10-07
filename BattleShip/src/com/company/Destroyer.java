package com.company;

import java.util.HashSet;

public class Destroyer extends Ship {

    public Destroyer(){
        this.length = 3;
        this.coordinates = new HashSet<>();
        this.shipID = 'D';
    }
}
