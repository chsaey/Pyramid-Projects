package com.company;
import java.util.Random;


public abstract class Character{
    protected int HP;
    protected int strength;
    protected String name;
    protected Random r = new Random();
    protected int row;
    protected int column;


    public int getStrength(){
        return strength;
    }
    public int getHP(){
        return HP;
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
    public void setRow(int row ){  this.row = row;  }
    public void setColumn(int column ){  this.column = column;  }
    public int getRow(){  return this.row;  }
    public int getColumn(){  return this.column;  }


    public int attack(Character obj){
        int dmg = rollDamage(getStrength());
        obj.setHP(obj.getHP()-dmg);
        System.out.println("<" + obj.getClass().getSimpleName() + " " + obj.getName() + " was hit for "+ dmg + " damage!>" );

        if (obj.getHP()<0){
            System.out.println("<" + obj.getName() + " has been slain!>\n" );
        }

        return obj.getHP();
    }



}
