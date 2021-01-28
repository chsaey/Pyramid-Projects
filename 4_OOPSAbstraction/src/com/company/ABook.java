package com.company;

public abstract class ABook {
    private String title;
    private String author;
    protected int dayTaken;


    //private int borrowDays;
    //private float overDueFee;

    public ABook(String title, int dayTaken) {
        this.title = title;
        this.dayTaken = dayTaken;
    }

    public ABook(String title, String author, int dayTaken) {
        this.title = title;
        this.author = author;
        this.dayTaken = dayTaken;
    }
}
