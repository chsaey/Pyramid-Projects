package com.company;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println(reverseInt(123));
    }

    public static int reverseInt(int value){
        String x = String.valueOf(value);
        StringBuilder sb = new StringBuilder(x).reverse();
        return Integer.parseInt(sb.toString());
    }
}
