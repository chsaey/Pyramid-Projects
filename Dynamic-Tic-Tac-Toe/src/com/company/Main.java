package com.company;

import com.google.gson.Gson;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public enum GameState {
        Name,
        Setup,
        Play,
        Reset,
        End
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<String> guesses = new HashSet<>();
        ArrayList<String> wordAsList = new ArrayList<>();
        String word = "";
        String name = "";
        GameState state = GameState.Name;

        while (true) {   //Game loop

            if (state == GameState.Name) {//name

                name = getName(scan);
                if (!name.equals(""))
                    state = GameState.Setup;
            } // end name state

            if (state == GameState.Setup) { // game state
                guesses = new HashSet<>();
                word = getWord();
                wordAsList = Stream.of(word.split("")).collect(Collectors.toCollection(ArrayList::new));
                state = GameState.Play;

            } // end game state

            if (state == GameState.Play) {
                HashSet<String> finalGuesses = guesses;
                ArrayList<String> finalWordAsList = wordAsList;
                ArrayList<String> playBoard = wordAsList.stream().map(n -> finalGuesses.contains(n) ? n : "_").collect(Collectors.toCollection(ArrayList::new));
                ArrayList<String> wrongBoard = guesses.stream().filter(n -> !finalWordAsList.contains(n)).collect(Collectors.toCollection(ArrayList::new));
                if (checkWin(!playBoard.contains("_"), word) || checkLoss(wrongBoard.size(), word)) {
                    printArt(playBoard, wrongBoard);
                    state = GameState.Reset;
                    continue;
                }

                printArt(playBoard, wrongBoard);
                getInput(scan, guesses);
            }// end play state

            if (state == GameState.Reset)
                state = reset(scan);

            if (state == GameState.End)
                break;
        }//end game loop
    }

    //methods for game
    public static void printArt(ArrayList<String> playBoard, ArrayList<String> wrongBoard) {
        Gson gson = new Gson();
        try {
            HashMap<String, String> map = new HashMap<>();
            map = gson.fromJson(new FileReader("C:\\Users\\chsae\\Documents\\Code\\Pyramid-Projects\\Dynamic-Tic-Tac-Toe\\src\\com\\company\\man.json", StandardCharsets.UTF_8), map.getClass());
            System.out.println("Missed letters: " + Arrays.toString(wrongBoard.toArray()));
            System.out.println(map.get(String.valueOf(wrongBoard.size())));
            System.out.println(Arrays.toString(playBoard.toArray()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setScore(int piece) {

    }

    public static boolean checkWin(boolean win, String word) {
        if (win) {
            System.out.println("You Won! The word was: " + word);
            return true;
        }
        return false;
    }

    public static boolean checkLoss(int guesses, String word) {
        if (guesses == 7) {
            System.out.println("You lost! The word was: " + word);
            return true;
        }
        return false;
    }

    public static String getWord() {
        Random r = new Random();
        String x = "";
        try {
            return Files.readAllLines(Paths.get("C:\\Users\\chsae\\Documents\\Code\\Pyramid-Projects\\Dynamic-Tic-Tac-Toe\\src\\com\\company\\WordBank")).get(r.nextInt(16));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return x;
    }

    public static String getName(Scanner scan) {
        System.out.println("What is your name?");
        try {
            return scan.nextLine();
        } catch (Exception e) {
            System.out.println("Something went wrong. Name is now Player by default");
        }
        return "";
    }

    public static void getInput(Scanner scan, HashSet<String> guesses) {
        System.out.println("Guess a letter: ");
        try {
            String guess = scan.nextLine().toLowerCase();
            if (!guess.matches("^[a-z]$") || !guesses.add(guess))
                throw new Exception("Invalid input or you've guessed this letter already. Try again.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static GameState reset(Scanner scan) {
        System.out.println("Play again? (y/n)");
        try {
            String input = scan.nextLine().toLowerCase();
            if (input.equals("y")) {
                return GameState.Name;
            }
            if (input.equals("n")) {
                return GameState.End;
            }
            throw new Exception("Invalid input. Try again");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return GameState.Reset;
    }
}
