package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class World {
    //grid of objects
    private Land[][] grid;
    private Human h;
    private ArrayList<Goblin> g;
    private Random r = new Random();
    private final int WIDTH = 10;
    private final int HEIGHT = 8;


    public World(Human h){
        this.h = h;
        this.g = new ArrayList<>(){{
            add(new Goblin("Bob"));
            add(new Goblin("Kevin"));
            add(new Goblin("Tim"));
        }};

        grid = new Land[HEIGHT][WIDTH];
        for(int row = 0; row < grid.length; row++){
            for(int column =0; column < grid[0].length;column++){
                grid[row][column] = new Land();
            }
        }
        this.h.setRow(r.nextInt(8));
        this.h.setColumn(0);

        this.g.get(0).setRow(r.nextInt(8));
        this.g.get(0).setColumn(5);

        this.g.get(1).setRow(r.nextInt(8));
        this.g.get(1).setColumn(7);

        this.g.get(2).setRow(r.nextInt(8));
        this.g.get(2).setColumn(9);

        grid[h.getRow()][h.getColumn()].setOn(h);
        for (Goblin gob: g
             ) {
            grid[gob.getRow()][gob.getColumn()].setOn(gob);
        }
    }

    public boolean goblinsAlive(){
        return g.size() > 0;
    }

    public ArrayList<Goblin> getGoblins(){
        return g;
    }
    public Human getHuman(){
        return h;
    }
    public void printLand(){
        System.out.println("");
        for(int row = 0; row < grid.length; row++){
            for(int column =0; column < grid[0].length;column++){
                System.out.print(grid[row][column].value+ " ");
            }
            System.out.println("");
        }
    }

    public LinkedHashMap<String,Object> checkGrid (int row, int column){
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        if (column-1 >= 0){
            result.putIfAbsent("west", grid[row][column-1].on);
        }
        if (row-1 >= 0 ){
            result.putIfAbsent("north", grid[row-1][column].on);
        }
        if (column+1 < WIDTH){
            result.putIfAbsent("east", grid[row][column+1].on);
        }
        if (row+1 < HEIGHT){
            result.putIfAbsent("south", grid[row+1][column].on);
        }

        return result;
    }

    public int getWorldWidth(){
        return WIDTH;
    }
    public int getWorldHeight(){
        return HEIGHT;
    }
    public void movePieceOnGrid(Character c,int row,int column){

        grid[c.getRow()][c.getColumn()].setOn(" ");
        grid[c.getRow()+row][c.getColumn()+column].setOn(c);
        c.setRow(c.getRow()+row);
        c.setColumn(c.getColumn()+column);

    }

    public void removePieceOnGrid(Character c){
        grid[c.getRow()][c.getColumn()].setOn(" ");
        g.remove(c);
    }



}
