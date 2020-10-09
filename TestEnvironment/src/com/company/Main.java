package com.company;

import static com.company.Test.*;

public class Main {

    public enum Roles {
        Admin,
        User,
        Mod,
    }

    public static void main(String[] args) {

        char c = 'A';
        System.out.println(++c);


    }

    public static String validRole(Roles role){
        switch (role){
            case Admin:
                return "yo";
            case User:
                return "user";
            case Mod:
                return "loser";
            default:
                return "none";
        }

    }
}


