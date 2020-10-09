package com.company;

public abstract class Ship {
    protected int length;
    protected String name;
    protected String country;

    public Ship(int length,String name,String country){
        this.length = length;
        this.name = name;
        this.country = country;
    }

    public int attack(Ship attack, Ship defend){
        System.out.println(attack.name + " Attacked " + defend.name);

        return 100;

    }

    protected abstract int defend();


}
