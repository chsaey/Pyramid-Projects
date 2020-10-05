package com.company;

public class Coordinate {
    private int row;
    private int column;
    private String id;

    public Coordinate(String input){
        this.row = row;
        this.column = getColumn();
        id = String.valueOf(row) + String.valueOf(column);
    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }

    public void setRow(int row){
        this.row = row;
    }
    public void setColumn(int column){
        this.column = column;
    }
    public boolean isValid(){
        return false;
    }


    public String toString(){
        return id;
    }
}
