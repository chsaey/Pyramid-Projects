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
    private final int WIDTH = 8;
    private final int HEIGHT = 10;


    public World(Human h, ArrayList<Goblin> g){
        this.h = h;
        this.g = g;
        grid = new Land[HEIGHT][WIDTH];
        for(int row = 0; row < grid.length; row++){
            for(int column =0; column < grid[0].length;column++){
                grid[row][column] = new Land();
            }
        }
        this.h.setX(r.nextInt(8));
        this.h.setY(0);

        this.g.get(0).setX(r.nextInt(8));
        this.g.get(0).setY(5);

        this.g.get(1).setX(r.nextInt(8));
        this.g.get(1).setY(7);

        this.g.get(2).setX(r.nextInt(8));
        this.g.get(2).setY(9);

        grid[h.getX()][h.getY()].setOn(h);
        for (Goblin gob: g
             ) {
            grid[gob.getX()][gob.getY()].setOn(gob);
        }
    }

    public void printLand(){
        for(int row = 0; row < grid.length; row++){
            for(int column =0; column < grid[0].length;column++){
                System.out.print(grid[row][column].value+ " ");
            }
            System.out.println("");
        }
    }

    public LinkedHashMap<String,Object> checkGrid (int x, int y){
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        if (x-1 >= 0){
            result.putIfAbsent("west", grid[x-1][y].on);
        }
        if (x+1 < WIDTH){
            result.putIfAbsent("north", grid[x+1][y].on);
        }
        if (y-1 >= 0){
            result.putIfAbsent("east", grid[x][y-1].on);
        }
        if (y+1 < HEIGHT){
            result.putIfAbsent("south", grid[x][y+1].on);
        }

        return result;
    }

    public int getWorldWidth(){
        return WIDTH;
    }
    public int getWorldHeight(){
        return HEIGHT;
    }
    public void setPieceOnGrid(Character c,int x,int y){

        //update grid
        //update character xy


    }



}
