package com.company;

import entity.DailyWeatherReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherMonitor {
    private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(DailyWeatherReport.class)
            .buildSessionFactory();
    private WeatherSensor sense = new WeatherSensor();
    private HashMap<String, DailyWeatherReport> weatherReports = new HashMap<>();
    private HashMap<Integer, Integer> daysInMonth = new HashMap<>();


    public WeatherMonitor() {
        daysInMonth.put(1, 31);
        daysInMonth.put(2, 28);
        daysInMonth.put(3, 31);
        daysInMonth.put(4, 30);
        daysInMonth.put(5, 31);
        daysInMonth.put(6, 30);
        daysInMonth.put(7, 31);
        daysInMonth.put(8, 31);
        daysInMonth.put(9, 30);
        daysInMonth.put(10, 31);
        daysInMonth.put(11, 30);
        daysInMonth.put(12, 31);
    }

    public float averageHighForMonth(String month, String year) {
        generateMonthTemps(new CustomDate(month, year));
        int total = 0;
        float count = 0;
        for (Map.Entry<String, DailyWeatherReport> temp : weatherReports.entrySet()) {
            if (temp.getKey().matches(month + "/\\d\\d/" + year)) {
                total += temp.getValue().getHighestTemp();
                count++;
            }
        }
        return total / count;
    }

    public float averageLowForMonth(String month, String year) {
        generateMonthTemps(new CustomDate(month, year));
        int total = 0;
        float count = 0;
        for (Map.Entry<String, DailyWeatherReport> temp : weatherReports.entrySet()) {
            if (temp.getKey().matches(month + "/\\d\\d/" + year)) {
                total += temp.getValue().getLowestTemp();
                count++;
            }
        }
        return total / count;
    }

    public void generateMonthTemps(CustomDate date) {
        for (int i = 1; i <= daysInMonth.get(Integer.parseInt(date.getMonth())); i++) {
            ArrayList<Integer> temps = sense.getHourlyWeatherData();
            addDailyReport(new CustomDate(date.getMonth(), String.valueOf(i), date.getYear()), temps);
        }
    }

    //Adds date, lowest temp, and highest temp to DB.
    public void addDailyReport(CustomDate date, ArrayList<Integer> dailyTemps) {
        Session session = factory.openSession();
        DailyWeatherReport report = new DailyWeatherReport(date.toString(), getLow(dailyTemps), getHigh(dailyTemps));
        try {
            session.beginTransaction();
            session.save(report);
            session.getTransaction().commit();
            weatherReports.putIfAbsent(date.toString(), report);
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            session.close();
        }
    }

    public WeatherSensor getSense() {
        return sense;
    }

    private int getHigh(ArrayList<Integer> dailyTemps) {
        int high = Integer.MIN_VALUE;
        for (int temp : dailyTemps) {
            high = Math.max(high, temp);
        }
        return high;
    }

    private int getLow(ArrayList<Integer> dailyTemps) {
        int low = Integer.MAX_VALUE;
        for (int temp : dailyTemps) {
            low = Math.min(low, temp);
        }
        return low;
    }

}
