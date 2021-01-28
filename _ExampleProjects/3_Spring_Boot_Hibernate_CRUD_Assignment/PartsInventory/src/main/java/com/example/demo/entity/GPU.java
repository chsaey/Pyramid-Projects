package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="gpu")
public class GPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int memory;
    @Column
    private int speed;
    @Column
    private String model;
    @Column(name="chipsetbrand")
    private String chipSetBrand;
    @Column
    private String manufacturer;
    @Column
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChipSetBrand() {
        return chipSetBrand;
    }

    public void setChipSetBrand(String chipSetBrand) {
        this.chipSetBrand = chipSetBrand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GPU{" +
                "id=" + id +
                ", memory=" + memory +
                ", speed=" + speed +
                ", model='" + model + '\'' +
                ", chipSetBrand='" + chipSetBrand + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
