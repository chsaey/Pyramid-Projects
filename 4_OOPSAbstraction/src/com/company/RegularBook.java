package com.company;

public class RegularBook extends ABook implements Book {

    private float overDueFee = .10f;
    private int borrowDays = 14;

    public RegularBook(String title, String author, int dayTaken) {
        super(title, author, dayTaken);

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
