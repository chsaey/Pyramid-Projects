package com.company;
import java.util.Random;


public abstract class Character{
    protected int HP;
    protected int strength;
    protected String name;
    protected Random r = new Random();
    protected int x;
    protected int y;


    public int getStrength(){
        return strength;
    }
    public int getHP(){
        return strength;
    }
    public String getName(){
        return name;
    }
    public void setHP(int HP){
        this.HP = HP;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setName(String mame){
        this.name = name;
    }
    public int rollDamage(int str){
        return r.nextInt(str);
    }
    public void setX(int x ){  this.x = x;  }
    public void setY(int y ){  this.y = y;  }
    public int getX(){  return this.x;  }
    public int getY(){  return this.y;  }


    public int attack(Character obj){
        int dmg = rollDamage(getStrength());
        obj.setHP(obj.getHP()-rollDamage(getStrength()));
        return obj.getHP();
    }



}
