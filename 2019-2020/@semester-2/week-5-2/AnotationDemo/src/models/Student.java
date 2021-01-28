package models;

import webtools.JsonProperty;

public class Student {

    // POJO
    // ORM
    // { "fname" : "Ivan", "lname" : "Ivanov", "year" : 4}

    @JsonProperty(alternativeName = "first_name")
    public String fname;

    public String lname;

    public int year;

    public Student(String fname, String lname, int year) {

        this.fname = fname;
        this.lname = lname;
        this.year = year;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String value) {
        this.fname = value;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.fname + " " + this.lname;
    }
}
