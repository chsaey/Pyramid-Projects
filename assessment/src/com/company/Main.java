package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(reverseString("Hello"));

    }

    public static String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}
