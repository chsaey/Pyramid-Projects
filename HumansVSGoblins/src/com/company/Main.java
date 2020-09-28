//1.	Everything must be objects: land/goblins/humans
//2.	You must override the toString method to represent each of the object
//3.	Create a grid for the game world
//4.	Use UTF characters for the players and goblins and the land
//5.	Game is turn based move: n/s/e/w
//6.	Once a human and goblin collide combat is initiated
//7.	Combat uses math.random

//8.	Extras:
//a.	human has inventory system
//b.	goblins have drops
//c.	stats can be modified by equipment
//d.	map gen random treasure chest after each round of combat
//e.	goblins pursue player

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	// write your code here
        //generate player
        //generate goblin list
        //generate the world with pieces
        System.out.println("Welcome to Humans VS Goblins!");

        //GameLoop
        boolean play = true;
        //game loop
        while(play){

        System.out.println("Please enter your characters name: ");

        String name = scan.next();
        Human h = new Human(name);
        Goblin bob = new Goblin("bob");
        Goblin kevin = new Goblin("kevin");
        Goblin tim = new Goblin("tim");
        ArrayList<Goblin> goblins = new ArrayList<>(){{
            add(bob);
            add(kevin);
            add(tim);
        }};

        World world = new World(h,goblins);
        boolean isPLayersTurn = false;
        //session loop
        while(true){
            world.printLand();
            isPLayersTurn = isPLayersTurn ? false:true;
            System.out.println("Your turn...\nOptions:\n");


            LinkedHashMap<String, Object> result = world.checkGrid(h.getX(), h.getY());
            printResult(result);


            while(true){//player choice
                System.out.println("What do you want to do?...");
                String input = scan.next();
                if(input.equals("w") && result.containsKey("west")){
                    if(result.get("west").getClass().getSimpleName().equals("Goblin")){
                        h.attack((Character)result.get("west"));
                    } else{
                        world.setPieceOnGrid(h,-1, 0);
                    }
                } else if(input.equals("n") && result.containsKey("north")){
                    if(result.get("north").getClass().getSimpleName().equals("Goblin")){
                        h.attack((Character)result.get("north"));
                    }else{
                        world.setPieceOnGrid(h,0, 1);
                    }
                } else if(input.equals("e") && result.containsKey("east")){
                    if(result.get("east").getClass().getSimpleName().equals("Goblin")){
                        h.attack((Character)result.get("east"));
                    }else{
                        world.setPieceOnGrid(h,1,0 );
                    }
                } else if(input.equals("s") && result.containsKey("south")){
                    if(result.get("south").getClass().getSimpleName().equals("Goblin")){
                        h.attack((Character)result.get("south"));
                    }else{
                        world.setPieceOnGrid(h,-1, 0);
                    }
                } else{
                    System.out.println("This is not a valid option. Try again");
                }
            }// end player choice


        }// end session loop

        }// end game loop
    }//end main

    public static void printResult(LinkedHashMap<String,Object> result){

        for ( Map.Entry<String, Object> e: result.entrySet()
        ) {
            switch(e.getValue().getClass().getSimpleName()){
                case "Land":
                    System.out.println(e.getKey().charAt(0) + ": Move" +e.getKey()+ ", there is nothing in your way");
                    break;
                case "Goblin":
                    System.out.println(e.getKey().charAt(0) + ": Attack the Goblin to your " +e.getKey());
            }

        }

    }


}
