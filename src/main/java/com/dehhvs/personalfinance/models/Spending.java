package com.dehhvs.personalfinance.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Spending {

    @Id
    @GeneratedValue
    private int id;
    private Float value;
    private Date date;

    public Spending(int id, Float value, Date date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public Spending() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
