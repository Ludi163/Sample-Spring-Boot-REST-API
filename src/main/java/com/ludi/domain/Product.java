package com.ludi.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(columnDefinition = "TEXT")
    private String name;
    private int amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date manufacturedOn;

    @ManyToOne
    private Manufacturer manufacturer;

    @SuppressWarnings("unused")
    public Product() {}

    public Product(String name, int amount, Date manufacturedOn, Manufacturer manufacturer) {
        this.name = name;
        this.amount = amount;
        this.manufacturedOn = manufacturedOn;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getManufacturedOn() {
        return manufacturedOn;
    }

    public void setManufacturedOn(Date manufacturedOn) {
        this.manufacturedOn = manufacturedOn;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", manufacturedOn=" + manufacturedOn +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
