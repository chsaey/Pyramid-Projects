package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        car.drive();
        motorcycle.drive();
        System.out.println(car.toString());
        System.out.println(motorcycle.toString());
    }
}
