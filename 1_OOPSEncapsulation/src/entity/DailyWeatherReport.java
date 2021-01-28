package entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;

//Student Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
//will mark a particular class as an entity bean, so it must have a no-argument constructor
@Table(name = "weather") //This is for the actual name of the database table name we are mapping to the class.
public class DailyWeatherReport {
    //variables with annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "lowest_temp")
    private int lowestTemp;

    @Column(name = "highest_temp")
    private int highestTemp;


    //Constructors
    public DailyWeatherReport() {

    }

    public DailyWeatherReport(String date, int lowestTemp, int highestTemp) {
        this.date = date;
        this.lowestTemp = lowestTemp;
        this.highestTemp = highestTemp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLowestTemp() {
        return lowestTemp;
    }

    public void setLowestTemp(int lowestTemp) {
        this.lowestTemp = lowestTemp;
    }

    public int getHighestTemp() {
        return highestTemp;
    }

    public void setHighestTemp(int highestTemp) {
        this.highestTemp = highestTemp;
    }

}
