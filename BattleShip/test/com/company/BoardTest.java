package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    Scanner scan = new Scanner(System.in);
    @BeforeEach
    void setUp(){
        board = new Board();
        board.setPlayer1("Charles");
        board.setPlayer2("Bob");
        Battleship battle = new Battleship();
        battle.addCoordinate(new Coordinate(1,1));
        battle.addCoordinate(new Coordinate(1,2));
        battle.addCoordinate(new Coordinate(1,3));
        battle.addCoordinate(new Coordinate(1,4));

        board.initializeShip(board.getPlayer1(),battle);
        board.initializeShip(board.getPlayer2(),battle);
    }

    @Test
    void setPlayer1() {
        board.setPlayer1("Kevin");
        assertNotEquals(board.getPlayer1(),null);
    }

    @Test
    void setPlayer2() {
        board.setPlayer2("Tom");
        assertNotEquals(board.getPlayer2(),null);
    }

    @Test
    void getPlayer1() {
        assertEquals(board.getPlayer1().getName(),"Charles","getPlayer1 failed");
    }

    @Test
    void getPlayer2() {
        assertEquals(board.getPlayer2().getName(),"Bob","getPlayer2 failed");
    }

    @Test
    void checkWin() {
        board.getPlayer2().clearShips();
        assertEquals(board.checkWin(board.getPlayer1(),board.getPlayer2()),true, "checkWin failed");
    }

    @Test
    void evaluateCoordinate() {
        assertEquals(board.evaluateCoordinate(new Coordinate(1,1),board.getPlayer1().getShipGrid()),false, "evaluateCoordinate failed");
    }

    @Test
    void canPlaceShip() {
        assertEquals(board.canPlaceShip(new Coordinate(1,1),"h",board.getPlayer1(),4),false, "canPlaceShip failed");
    }

    @Test
    void namePhase() {
        assertEquals(board.namePhase(),"test");
    }

    @Test
    void battlePhase() {
        assertEquals(board.battlePhase(board.getPlayer1(),board.getPlayer2()),false);
    }

}