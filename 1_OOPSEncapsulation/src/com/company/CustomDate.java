package com.company;

public class CustomDate {
    private String month;
    private String day;
    private String year;

    public CustomDate() {
    }

    public CustomDate(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public CustomDate(String month, String year) {
        this.month = month;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        if (!day.equals("")) {
            return month +
                    "/" +
                    day +
                    "/" +
                    year;
        }else{
            return month +
                    "/" +
                    year;
        }
    }
}
