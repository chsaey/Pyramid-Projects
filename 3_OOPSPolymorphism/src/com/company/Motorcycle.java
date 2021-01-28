package com.company;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        super(2, 1, 0);
    }

    @Override
    void drive() {
        System.out.println("Vroooom");

    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "wheels=" + wheels +
                ", seats=" + seats +
                ", doors=" + doors +
                '}';
    }


}
