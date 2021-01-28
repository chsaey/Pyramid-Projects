package com.company;

public class AudioBook extends ABook implements Book {

    private float overDueFee = .20f;
    private int borrowDays = 14;

    public AudioBook(String title, String author, int dayTaken) {
        super(title, author, dayTaken);
        //setOverDueFee(.20f);
        //setBorrowDays(14);

    }


    @Override
    public int daysOverdue(int day) {
        return day - (dayTaken + borrowDays);
    }

    @Override
    public boolean isOverdue(int day) {
        return daysOverdue(day) > 0;
    }

    @Override
    public float computeFine(int day) {
        return overDueFee * daysOverdue(day);
    }
}
