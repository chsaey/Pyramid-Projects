package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    Grid grid = new Grid();

    @Test
    void getPointOnGrid() {
        char answer = grid.getPointOnGrid(new Coordinate(1,1));
        assertEquals(answer,'~', "getPoint failed");
    }

    @Test
    void setPointOnGrid() {
        grid.setPointOnGrid(new Coordinate(1,1),'B');
        char answer = grid.getPointOnGrid(new Coordinate(1,1));
        assertEquals(answer,'B', "getPoint failed");
    }

    @Test
    void checkGrid() {
        assertEquals(grid.checkGrid(new Coordinate(1,1)),true);
    }
}