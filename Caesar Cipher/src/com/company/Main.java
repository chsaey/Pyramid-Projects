package com.company;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean play = true;
        while (play) {
            System.out.println("Do you wish to encrypt or decrypt a message?\n");
            try {

                switch (scan.nextLine().toLowerCase()) {
                    case "encrypt":
                        encrypt();
                        break;
                    case "decrypt":
                        decrypt();
                        break;
                    default:
                        throw new Exception("Please enter encrypt or decrypt!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void encrypt() {
        Scanner scan = new Scanner(System.in);
        char[] message = getMessage();
        int key = getKey();

        //encrypt
        StringBuilder sb = new StringBuilder();
        for (char c : message
        ) {
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                for (int i = 0; i < key; i++) {
                    if (c == 122) {
                        c = 65;
                    } else if (c == 90) {
                        c = 97;
                    } else {
                        c++;
                    }
                }
            }
            sb.append(c);
        }
        try {
            Files.write(Paths.get("C:\\Users\\chsae\\Documents\\Code\\Pyramid-Projects\\Caesar Cipher\\src\\com\\company\\message.txt"), sb.toString().getBytes(StandardCharsets.UTF_8));
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public static void decrypt() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> message = new ArrayList<>();
        try{message.addAll(Files.readAllLines(Paths.get("C:\\Users\\chsae\\Documents\\Code\\Pyramid-Projects\\Caesar Cipher\\src\\com\\company\\message.txt")));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nEncrypted message: " + message.get(0));
        char[] cryptic;
        int key = getKey();
        StringBuilder sb = new StringBuilder();
            cryptic = message.get(0).toCharArray();
            for (char c : cryptic
            ) {
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                    for (int i = 0; i < key; i++) {
                        if (c == 65) {
                            c = 122;
                        } else if (c == 97) {
                            c = 90;
                        } else {
                            c--;
                        }
                    }
                }
sb.append(c);
            }
        System.out.println("Decrypted message with key: " + sb.toString() + "\n");
    }

    public static char[] getMessage() {
        Scanner scan = new Scanner(System.in);
        while (true) { // Message
            System.out.println("Enter your Message:\n");
            try {
                return scan.nextLine().toCharArray();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getKey() {
        Scanner scan = new Scanner(System.in);
        while (true) { //key
            System.out.println("Enter the key number (1-52):\n");
            try {
                int key = Integer.parseInt(scan.nextLine());
                if (key < 1 || key > 52) {
                    throw new Exception("Please enter a valid key:\n");
                }
                return key;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

}
