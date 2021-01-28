package com.company;

import java.util.Scanner;
//WeatherMonitor -> only stores DailyWeather Report which contains date(Month,day,Year) and lowest temp and highest temp, not avg
//WeatherSensor -> Gathers the weather data. produces readings containing time of the reading, and temp
//How to gen temps, RNG or API?

public class Main {

    static WeatherMonitor monitor = new WeatherMonitor();

    public static void main(String[] args) {

        System.out.println("Welcome to Weather Reports!");
        boolean play = true;
        while (play) {
            menu();
            play = readInput();
        }
    }

    private static void menu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Get an average monthly high temperature?");
        System.out.println("2. Get an average monthly low temperature?");
        System.out.println("3. Add a daily report");
        System.out.println("0. Exit");
    }

    private static boolean readInput() {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("Please enter a month (1-12)");
        String month= scan.nextLine();
        System.out.println("Please enter a year (XXXX)");
        String year = scan.nextLine();

        switch (input) {
            case "1":

                System.out.println(monitor.averageHighForMonth(month, year));
                return true;
            case "2":
                System.out.println(monitor.averageLowForMonth(month, year));
                return true;
            case "3":
                System.out.println("Please enter a year day");
                String day = scan.nextLine();
                monitor.addDailyReport(new CustomDate(month,day,year), monitor.getSense().getHourlyWeatherData());
                return true;
            case "0":
                return false;
            default:
                return true;
        }



    }
}

