package com.company;

import entity.Hangman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Hangman.class)
                .buildSessionFactory();

        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<String> wordBank = new ArrayList<>() {{
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
        while (play) {   //Game loop

            //Setup
            String[] pieces = {" ", " ", " ", " ", " ", " ", " "};
            ArrayList<String> wrongLetters = new ArrayList<>();
            ArrayList<String> correctLetters = new ArrayList<>();
            ArrayList<String> wordAsList = new ArrayList<>();
            String word = wordBank.get(r.nextInt(wordBank.size()));
            int wrongGuesses = 0;
            String name = "Default";
            try {
                System.out.println("What is your name?");
                name = scan.next();
            } catch (Exception e) {
                System.out.println("error");
            }


            //initialize wordAsList and correct letters
            Collections.addAll(wordAsList, word.split(""));
            for (int i = 0; i < wordAsList.size(); i++) {
                correctLetters.add("_");
            }

            System.out.println("H A N G M A N");
            while (true) {//Session loop
                printGame(pieces, wrongLetters, correctLetters);
                System.out.println("Take a guess:\n");

                try {
                    String guess = scan.next();

                    // Check if it's a single character a-z
                    if (guess.length() != 1 || !guess.matches("[a-z]")) {
                        throw new Exception("Invalid input. Please enter a single character");
                    }

                    // Check if we've seen the character
                    if (wrongLetters.contains(guess) || correctLetters.contains(guess)) {
                        throw new Exception("You've already guessed this letter. Try again.");
                    }

                    //check if character is in generated word
                    if (word.contains(guess)) {
                        //loop through the word,
                        for (int i = 0; i < wordAsList.size(); i++) {
                            if (wordAsList.get(i).equals(guess)) {
                                correctLetters.set(i, guess);
                            }
                        }

                        if (correctLetters.equals(wordAsList)) { //win condition


                            System.out.println(Arrays.toString(correctLetters.toArray()));
                            System.out.println("Yes! The secret word is \"" + word + "\"! You have won!");
                            createRecord(factory, name, word, wrongGuesses);

                            break;
                        }
                    } else {
                        wrongGuesses++;
                        wrongLetters.add(guess);
                        setPiece(wrongGuesses, pieces);
                        if (wrongGuesses == 7) {  //lose condition
                            printGame(pieces, wrongLetters, correctLetters);
                            System.out.println("You lose! The word was: " + word);
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }//end session loop

            while (true) { //reset loop
                try {
                    System.out.println("Do you want to play again? (yes or no)...");
                    String reset = scan.next().toLowerCase();
                    if (reset.equals("no")) {
                        play = false;
                        break;
                    } else if (reset.equals("yes")) {
                        break;
                    }
                    throw new Exception("Expected yes or no.");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }//end game loop
    }

    public static void createRecord(SessionFactory factory, String name, String word, int wrongGuesses) {
        try {
            Session session = factory.getCurrentSession();
            Hangman entry = new Hangman(name, word, wrongGuesses);
            session.beginTransaction();
            session.save(entry);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error");

        } finally {
            factory.close();

        }

    }

    //methods for game
    public static void printGame(String[] pieces, ArrayList<String> wrongLetters, ArrayList<String> correctLetters) {
        System.out.println("+---+");
        System.out.printf(" %s  |\n", pieces[0]);
        System.out.printf("%s%s%s |\n", pieces[5], pieces[1], pieces[6]);
        System.out.printf(" %s  |\n", pieces[2]);
        System.out.printf("%s %s === \n", pieces[3], pieces[4]);
        System.out.print("Missed letters: ");
        System.out.println(Arrays.toString(wrongLetters.toArray()));
        System.out.println("\n" + Arrays.toString(correctLetters.toArray()) + "\n");
    }

    public static void setPiece(int piece, String[] pieces) {
        switch (piece) {
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
