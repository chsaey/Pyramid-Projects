package com.company;

public class Coordinate {
    private int row;
    private int column;
    private String id;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        id = String.valueOf(this.row) + String.valueOf(this.column);
    }

    public Coordinate(String input) {
        this.row = Integer.parseInt(input.substring(1, 2));
        this.column = Integer.parseInt(input.substring(3, 4));
        id = String.valueOf(row) + String.valueOf(column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        id = String.valueOf(this.row) + String.valueOf(this.column);
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isValid() {
        if (this.row <= 9 && this.row > 0 && this.column <= 9 && this.column > 0) {
            return true;
        }
        return false;
    }

    public boolean isEqual(Coordinate coordinate) {
        if (coordinate.getId().equals(this.id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return id;
    }
}
