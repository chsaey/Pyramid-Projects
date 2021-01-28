package com.company.explore;

public class DogTest
{
    public static void main(String[] args)
    {
        Labrador lab = new Labrador("Bob","Chocolate");
        Yorkshire yorkie = new Yorkshire("Ben");
        System.out.println(lab.avgBreedWeight());
        System.out.println(yorkie.avgBreedWeight());

    }
}

