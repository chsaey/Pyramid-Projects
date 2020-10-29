package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.company.Test.*;
class MultithreadingDemo extends Thread implements Runnable
{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}

interface Function3<One,Two,Three,Result>{
    public Result apply(One one, Two two, Three three);
}

 class Main{

    float x = 1.1f;

    int t = (int) x;
    protected class t{}

    public static void main(String[] args) throws IOException {
        Function<Integer,Integer> f = (x) -> {return x*x;};
        Function3<>

        System.out.println("yo");
        System.out.println("yo");
        System.out.println("yo");
        System.out.println("yo");
        System.out.println("yo");
        System.out.println("yo");
        System.out.println("yo");



    }


}


