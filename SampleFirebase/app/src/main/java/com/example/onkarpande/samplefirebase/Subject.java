package com.example.onkarpande.samplefirebase;

public class Subject {
    private String breakfast;
    private String lunch;
    private String snacks;
    private String dinner;

    public Subject()
    {

    }

    public Subject(String breakfast, String lunch, String snacks, String dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.snacks = snacks;
        this.dinner = dinner;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getSnacks() {
        return snacks;
    }

    public String getDinner() {
        return dinner;
    }

}
