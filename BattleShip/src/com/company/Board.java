package com.company;

public class Board {
    private Player player1;
    private Player player2;


    public Board(){

    }

    public void setPlayer1(String name){
        player1 = new Player(name);

    }
    public void setPlayer2(String name){
        player2 = new Player(name);

    }
    public Player getPlayer1(){
        return player1;

    }
    public Player getPlayer2(){
        return player2;

    }
}
