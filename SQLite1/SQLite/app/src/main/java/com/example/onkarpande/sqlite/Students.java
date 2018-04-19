package com.example.onkarpande.sqlite;

/**
 * Created by Onkar Pande on 10/25/2017.
 */

public class Students {

    private int roll;
    private String studentName;

    //Added this empty constructor in lesson 50 in case we ever want to create the object and assign it later.
    public Students(){

    }
    public Students(String studentName ,int roll) {
        this.studentName = studentName;
        this.roll=roll;
    }

    public int get_roll() {
        return roll;
    }

    public String get_studentname() {
        return studentName;
    }


}
