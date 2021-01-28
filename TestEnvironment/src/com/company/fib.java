package com.company;

class fib {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;

        for(int i = 3; i<= n;i++){
            int third = first + second;
            first = second;
            second = third;

        }
        return second;

    }


}