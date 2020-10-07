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

import com.sun.jdi.connect.spi.TransportService;
import jdk.jshell.spi.ExecutionControlProvider;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Humans VS Goblins!");

        boolean play = true;
        //Game loop
        while (play) {

            System.out.println("Please enter your characters name: ");
            String name = "";
            try {
                while (true) {
                    name = scan.next();
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Human h = new Human(name);
            World world = new World(h);
            boolean isPLayersTurn = false;
            int round = 0;

            //session loop
            while (h.getHP() > 0 && world.goblinsAlive()) {

                isPLayersTurn = isPLayersTurn ? false : true;

                //player turn
                if (isPLayersTurn) {
                    round++;
                    System.out.println("------ Round " + round + " ------");
                    System.out.print(h.toString());
                    world.printLand();
                    playerTurn(h, world, scan);
                } else {
                    goblinsTurn(world);
                }
                //Goblins turn

            }// end session loop

            if (h.getHP() <= 0) {
                world.removePieceOnGrid(h);
                System.out.println("You were Killed by a Goblin... Game Over!");
            } else {
                System.out.println("All Goblins have been slain!... You Win!");
            }
            System.out.print(h.toString());
            world.printLand();
            while (true) {
                try {
                    System.out.println("Play Again?...(y or n)");
                    String input = scan.next();
                    if (input.toLowerCase().equals("n")) {
                        play = false;
                        break;
                    } else if (input.toLowerCase().equals("y")) {
                        break;
                    }
                    throw new Exception("Expected y or n...");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }// end game loop

    }//end main

    public static void goblinsTurn(World world) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        for (Goblin g : world.getGoblins()) {
            result = world.checkGrid(g.getRow(), g.getColumn());
            if (result.containsValue(world.getHuman())) {
                g.attack(world.getHuman());
            } else {
                String[] keyArray = result.keySet().toArray(new String[result.keySet().size()]);
                Random r = new Random();
                int choice = r.nextInt(keyArray.length);

                switch (keyArray[choice]) {
                    case "west":
                        world.movePieceOnGrid(g, 0, -1);
                        break;
                    case "north":
                        world.movePieceOnGrid(g, -1, 0);
                        break;
                    case "east":
                        world.movePieceOnGrid(g, 0, 1);
                        break;
                    case "south":
                        world.movePieceOnGrid(g, 1, 0);
                        break;
                }
            }
        }
    }

    public static void playerTurn(Human h, World world, Scanner scan) {
        while (true) {//player choice
            try {
                LinkedHashMap<String, Object> result = world.checkGrid(h.getRow(), h.getColumn());
                printResult(result);
                System.out.println("\nWhat do you want to do?...");
                String input = scan.next();
                if (input.equals("w") && result.containsKey("west")) {
                    if (!isAttack(result, "west", h, world)) {
                        world.movePieceOnGrid(h, 0, -1);
                    }
                    break;
                } else if (input.equals("n") && result.containsKey("north")) {
                    if (!isAttack(result, "north", h, world)) {
                        world.movePieceOnGrid(h, -1, 0);
                    }
                    break;
                } else if (input.equals("e") && result.containsKey("east")) {
                    if (!isAttack(result, "east", h, world)) {
                        world.movePieceOnGrid(h, 0, 1);
                    }
                    break;
                } else if (input.equals("s") && result.containsKey("south")) {
                    if (!isAttack(result, "south", h, world)) {
                        world.movePieceOnGrid(h, 1, 0);
                    }
                    break;
                } else {
                    throw new Exception("OPTION INVALID. TRY AGAIN.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }// end player choice
    }

    public static void printResult(LinkedHashMap<String, Object> result) {

        for (Map.Entry<String, Object> e : result.entrySet()
        ) {
            switch (e.getValue().getClass().getSimpleName()) {
                case "String":
                    System.out.println(e.getKey().charAt(0) + ") Move " + e.getKey() + ", there is nothing in your way...");
                    break;
                case "Goblin":
                    System.out.println(e.getKey().charAt(0) + ") Attack the monster to your " + e.getKey() + ":");
                    System.out.println(result.get(e.getKey()).toString());
                    break;
                case "Human":
                    System.out.println(e.getKey().charAt(0) + ") Attack the Human to your " + e.getKey() + ":");
                    System.out.println(result.get(e.getKey()).toString());
                    break;
            }
        }
    }

    public static boolean isAttack(LinkedHashMap<String, Object> result, String direction, Human h, World w) {

        String name = result.get(direction).getClass().getSimpleName();
        if (name.equals("Goblin")) {
            Character goblin = (Character) result.get((direction));
            if (h.attack(goblin) <= 0) {
                w.removePieceOnGrid(goblin);
            }
            return true;
        } else {
            return false;
        }
    }
}
