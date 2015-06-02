package com.bxs.retrofitsample.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by bhupinder on 2/6/15.
 */
public class Employee implements Serializable {

    private int id;
    private String name;
    private String age;
    private String dateOfJoining;

    private ArrayList<Salary> Salaries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public ArrayList<Salary> getSalaries() {
        return Salaries;
    }

    public void setSalaries(ArrayList<Salary> salaries) {
        this.Salaries = salaries;
    }
}
