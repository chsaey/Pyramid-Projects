package com.company.explore;

public class Labrador extends Dog {

    public Labrador(String name, String color) {
        super(name);
    }

    public String speak() {
        return "WOOF";
    }

    public int avgBreedWeight() {
        return 75;
    }

}
