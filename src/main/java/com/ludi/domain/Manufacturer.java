package com.ludi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String country;

    @SuppressWarnings("unused")
    public Manufacturer() {}

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' + '}';
    }
}
