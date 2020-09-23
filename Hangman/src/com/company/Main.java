package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<String> wordBank = new ArrayList<>(){{
            add("cat");
            add("crab");
            add("garbage");
            add("sound");
            add("wallet");
            add("gorilla");
            add("python");
            add("fan");
            add("dog");
            add("rainbow");
            add("yogurt");
            add("zebra");
            add("lion");
            add("house");
            add("balloon");
            add("computer");
        }};

        boolean play = true;

        while(play){   //Game loop

            //Setup
            String[] pieces = {" "," "," "," "," "," "," "};
            ArrayList<String> wrongLetters = new ArrayList<>();
            ArrayList<String> correctLetters = new ArrayList<>();

            ArrayList<String> wordList = new ArrayList<>();
            String word = wordBank.get(r.nextInt(wordBank.size()));
            int wrongGuesses = 0;

            //initialize wordlist and correct letters
            Collections.addAll(wordList, word.split(""));
            for(int i = 0; i < wordList.size(); i++){
                correctLetters.add("_");
            }



            System.out.println("H A N G M A N");

            while(true){//Session loop
            printGame(pieces,wrongLetters,correctLetters);
            System.out.println("Take a guess:\n");
            String guess = scan.next().toLowerCase();

            if(guess.length()!=1 || !guess.matches("[a-z]")){
                System.out.println("Please enter a single character");
                continue;
            }

            if(wrongLetters.contains(guess) || correctLetters.contains(guess)){
                System.out.println("You've already guessed this letter. Try again.");
                continue;
            }

            if(word.contains(guess)){
                for(int i = 0; i < wordList.size(); i++){
                    if(wordList.get(i).equals(guess)){
                        correctLetters.set(i,guess);
                    }
                }

                if(correctLetters.equals(wordList)){ //win condition
                    System.out.println(Arrays.toString(correctLetters.toArray()));
                    System.out.println("Yes! The secret word is \"" + word+ "\"! You have won!");
                    break;
                }
            }
            else{
                wrongGuesses++;
                wrongLetters.add(guess);
                setPiece(wrongGuesses,pieces);

                if(wrongGuesses == 7) {  //lose condition
                    printGame(pieces,wrongLetters,correctLetters);
                    System.out.println("You lose! The word was: " + word);
                    break;
                }

            }


            }//end session loop

            while(true){ //reset loop
            System.out.println("Do you want to play again? (yes or no)...");
            String reset = scan.next().toLowerCase();
            if(reset.matches("no")){
                play=false;
                break;
            }
            else if(reset.matches("yes")){
               break;
            }
            System.out.println("Enter yes or no!");
            }

        }//end game loop
    }

    //methods for game
    public static void printGame(String[] pieces, ArrayList<String> wrongLetters,ArrayList<String> correctLetters){
        System.out.println("+---+");
        System.out.printf(" %s  |\n", pieces[0]);
        System.out.printf("%s%s%s |\n",pieces[5],pieces[1],pieces[6]);
        System.out.printf(" %s  |\n",pieces[2]);
        System.out.printf("%s %s === \n",pieces[3],pieces[4]);
        System.out.print("Missed letters: ");
        System.out.println(Arrays.toString(wrongLetters.toArray()));
        System.out.println("\n"+Arrays.toString(correctLetters.toArray())+"\n");

    }

    public static void setPiece(int piece, String[] pieces){
        switch(piece){
            case 1:
                pieces[0] = "O";
                break;
            case 2:
                pieces[1] = "|";
                break;
            case 3:
                pieces[2] = "|";
                break;
            case 4:
                pieces[3] = "/";
                break;
            case 5:
                pieces[4] = "\\";
                break;
            case 6:
                pieces[5] = "/";
                break;
            case 7:
                pieces[6] = "\\";
                break;
            default:
                break;
        }
    }
}
