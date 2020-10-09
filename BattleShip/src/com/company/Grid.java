package com.company;

import java.util.ArrayList;

public class Grid {
    private char[][] grid = {
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
    };

    public Grid(){

    }

    public char[][] getGrid(){
        return this.grid;
    }

    public void printGrid(){
        System.out.println("  1 2 3 4 5 6 7 8 9");
        int index =1;
        for ( char[] c: grid
             ) {
            System.out.print(index+ " ");
            index++;
            for(int i = 0; i < c.length; i++){

                System.out.print(c[i] + " ");
            }
            System.out.println();
        }
    }

    public char getPointOnGrid(Coordinate coordinate){
        return grid[coordinate.getRow()-1][coordinate.getColumn()-1];
    }
    public void setPointOnGrid(Coordinate coordinate, char marker){
        grid[coordinate.getRow()-1][coordinate.getColumn()-1] = marker;
    }

    public boolean checkGrid(Coordinate coordinate){
        if(grid[coordinate.getRow()-1][coordinate.getColumn()-1] == '~'){
            return true;
        }
        return false;
    }

    public void placeOnGrid(Coordinate coordinate, char shipID){
        this.grid[coordinate.getRow()-1][coordinate.getColumn()-1] = shipID;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        System.out.println("  1 2 3 4 5 6 7 8 9");
        int index =1;
        for ( char[] c: grid
        ) {
            System.out.print(index+ " ");
            index++;
            for(int i = 0; i < c.length; i++){

                sb.append(c[i] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }









}
