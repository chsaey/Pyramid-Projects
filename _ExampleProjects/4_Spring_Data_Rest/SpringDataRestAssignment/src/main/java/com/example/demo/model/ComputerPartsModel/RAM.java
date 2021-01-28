package com.example.demo.model.ComputerPartsModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name="ram")
public class RAM {
    @Id
    @Column
    private int id;
    @Column
    private String brand;
    @Column
    private String Series;
    @Column
    private String type;
    @Column
    private int memory;
    @Column
    private BigDecimal price;

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
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", Series='" + Series + '\'' +
                ", type='" + type + '\'' +
                ", memory=" + memory +
                ", price=" + price +
                '}';
    }
}
