package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cpu")
public class CPU {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "series")
    private String series;

    @Column(name = "cores")
    private int cores;

    @Column(name = "speed")
    private BigDecimal speed;

    @Column(name = "price")
    private BigDecimal price;

    //No argument constructor for entity bean
    public CPU() {
    }


    public CPU(String brand, String series, int cores, BigDecimal speed, BigDecimal price) {
        this.brand = brand;
        this.series = series;
        this.cores = cores;
        this.speed = speed;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", brand ='" + brand + '\'' +
                ", series='" + series + '\'' +
                ", cores='" + cores + '\'' +
                ", speed='" + speed + '\'' +
                ", price='" + price +
                '}';
    }
}
