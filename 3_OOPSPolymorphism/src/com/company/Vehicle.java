package com.company;

public abstract class Vehicle {

    protected int wheels;
    protected int seats;
    protected int doors;

    public Vehicle (int wheels, int seats, int doors){
        this.wheels = (wheels);
        this.seats = seats;
        this.doors = doors;
    }
    abstract void drive();

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", seats=" + seats +
                ", doors=" + doors +
                '}';
    }


}
