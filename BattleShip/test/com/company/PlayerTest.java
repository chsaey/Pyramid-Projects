package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Board board;
    Battleship battle;
    char[][] playGrid = {
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

    char[][] shipGrid = {
            {'B','B','B','B','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~'},
    };


    @BeforeEach
    void setUp() {
        board = new Board();
        board.setPlayer1("Charles");
        board.setPlayer2("Bob");
        battle = new Battleship();
        battle.addCoordinate(new Coordinate(1,1));
        battle.addCoordinate(new Coordinate(1,2));
        battle.addCoordinate(new Coordinate(1,3));
        battle.addCoordinate(new Coordinate(1,4));

        board.initializeShip(board.getPlayer1(),battle);
        board.initializeShip(board.getPlayer2(),battle);

    }

    @Test
    void hitShip() {
        assertEquals(board.getPlayer1().hitShip('B',new Coordinate(1,1)),"");
    }

    @Test
    void getShips() {

        assertEquals(board.getPlayer1().getShips().get('B'),battle.getCoordinates());
    }

    @Test
    void getPlayGrid() {

        assertEquals(Arrays.deepEquals(board.getPlayer1().getPlayGrid().getGrid(),playGrid),true);
    }

    @Test
    void getShipGrid() {
        assertEquals(Arrays.deepEquals(board.getPlayer1().getShipGrid().getGrid(),shipGrid),true);
    }

    @Test
    void getName() {
        assertEquals(board.getPlayer1().getName(),"Charles");
        assertEquals(board.getPlayer2().getName(),"Bob");

    }

}