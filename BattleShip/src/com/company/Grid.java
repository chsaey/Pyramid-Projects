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

    public boolean checkGrid(int row, int column){
        if(grid[row][column] == '~'){
            return true;
        }
        return false;
    }




}
