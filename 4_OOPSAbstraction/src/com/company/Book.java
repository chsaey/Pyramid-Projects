package com.company;

public interface Book {

    int daysOverdue(int days);
    public boolean isOverdue(int day);
    public float computeFine(int day);

}
