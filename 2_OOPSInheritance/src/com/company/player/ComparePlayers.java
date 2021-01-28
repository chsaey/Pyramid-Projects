package com.company.player;

import java.util.Scanner;
public class ComparePlayers
{
    public static void main(String[] args)
    {
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner scan = new Scanner(System.in);
        //Prompt for and read in information for player 1
        System.out.println("Enter player 1 information");
        player1.readPlayer();
        //Prompt for and read in information for player 2
        System.out.println("Enter player 2 information");
        player2.readPlayer();
        //Compare player1 to player 2 and print a message saying
        System.out.println(player1.equals(player2));

        // whether they are equal
    }


}
