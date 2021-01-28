package com.company;

import java.util.ArrayList;
import java.util.Random;

public class WeatherSensor {

    WeatherSensor(){

    }

    //randomly generation temps for one day every hour. Returns a list of temps for a date to use.
    public ArrayList<Integer> getHourlyWeatherData(){
        Random random = new Random();
        ArrayList<Integer> temps = new ArrayList<>();
        for(int i = 0; i <23; i++){
            temps.add(random.nextInt(30)+40);
        }
        return temps;
    }





}
