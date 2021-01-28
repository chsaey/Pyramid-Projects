package com.company;

public class ReferenceBook extends ABook implements Book {

    private float overDueFee = .10f;
    private int borrowDays = 2;
    public ReferenceBook(String title, int dayTaken) {
        super(title, dayTaken);
        //setOverDueFee(.10f);
        //setBorrowDays(2);
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
