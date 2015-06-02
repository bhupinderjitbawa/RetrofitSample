package com.bxs.retrofitsample.models;

import java.io.Serializable;

/**
 * Created by bhupinder on 2/6/15.
 */
public class Salary implements Serializable {

    private int id;
    private float salaryAmount;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(float salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
