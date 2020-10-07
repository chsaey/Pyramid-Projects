package com.company;

import java.util.HashSet;

public class PatrolBoat extends Ship {

    public PatrolBoat(){
        this.length = 2;
        this.coordinates = new HashSet<>();
        this.shipID = 'P';
    }
}
