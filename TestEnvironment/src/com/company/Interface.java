package com.company;

public interface Interface {

    public static final int x = 2;

     void testMethod();
     default void defaultMethod(){
         System.out.println("yo");
     }

}
