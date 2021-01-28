package com.company.player;

import java.util.Scanner;
public class Player
{
    private String name;
    private String team;
    private int jerseyNumber;

    public void readPlayer()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name: ");
        name = scan.nextLine();
        System.out.print("Team: ");
        team = scan.nextLine();
        System.out.print("Jersey number: ");
        jerseyNumber = scan.nextInt();
    }


    public boolean equals(Player player2) {
        return (name.equals(player2.name) && team.equals(player2.team)&&jerseyNumber == player2.jerseyNumber);
    }



}
