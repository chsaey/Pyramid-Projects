package com.company;

public class Goblin extends Character {

    public Goblin(String name){
        this.name = name;
        this.HP = r.nextInt(25)+15;
        this.strength = r.nextInt(5)+6;
    }

    public String toString() {
        return "Type: Goblin "+ "Name: " + this.name + "HP : " + this.HP + "Strength : " + this.strength;
    }

}
