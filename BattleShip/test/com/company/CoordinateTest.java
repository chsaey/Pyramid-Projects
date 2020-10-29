package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

class CoordinateTest {
    Coordinate coordinate;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Coordinate tests: ");
    }

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(1, 5);
    }

    @Test
    void getRow() {
        assertEquals(coordinate.getRow(), 1, "getRow failed.");
    }

    @Test
    void getColumn() {
        assertEquals(coordinate.getColumn(), 5, "getColumn failed");
    }

    @Test
    void getId() {
        assertEquals(coordinate.getId(), "15", "getID failed");
    }

    @Test
    void setId() {
        coordinate.setRow(2);
        coordinate.setColumn(8);
        coordinate.setId();
        assertEquals(coordinate.getId(), "28", "getID failed");
    }

    @Test
    void setRow() {
        coordinate.setRow(2);
        assertEquals(coordinate.getRow(), 2);
    }

    @Test
    void setColumn() {
        coordinate.setColumn(8);
        assertEquals(coordinate.getColumn(), 8, "setColumn failed");
    }

    @Test
    void isValid() {
        coordinate.setColumn(10);
        coordinate.setRow(11);
        assertEquals(coordinate.isValid(), false, "isValid failed");
    }

    @Test
    void isEqual() {
        Coordinate test = new Coordinate(1, 5);
        assertEquals(coordinate.isEqual(test), true, "isEqual Failed");
    }

    @Test
    void testToString() {
        assertEquals(coordinate.toString(), coordinate.getId(), "testToString failed");
    }
}