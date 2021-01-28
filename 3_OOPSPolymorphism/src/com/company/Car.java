package com.company;

public class Car extends Vehicle {

    public Car() {
        super(4, 4, 4);
    }

    @Override
    void drive() {
        System.out.println("zoom zoom");
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                ", seats=" + seats +
                ", doors=" + doors +
                '}';
    }
}

