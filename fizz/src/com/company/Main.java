package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(fizz(10));

    }

    public static String fizz(int num){

        if (num % 3 == 0 && num % 5==0){
            return "fizz buzz bazz";
        }
        if( num % 3 == 0){
            return "fizz";
        }
        if (num % 5 == 0){
            return"buzz";
        }
        return "nothing";

    }
}
