package com.company;

public class Human extends Character {

    public Human(String name){
        this.name = name;
        this.HP = 50;
        this.strength = r.nextInt(10)+10;
    }


    @Override
    public String toString() {
        return "Type: Human"+ "\nName: " + this.name + "\nHP : " + this.HP + "\nStrength : " + this.strength;
    }
}
