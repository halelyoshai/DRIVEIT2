package com.example.driveit;

import java.util.ArrayList;

public class Student extends Person
{

    private int testpnimi;
    private int numlessons;
    private int numtests;
    private String personalpic;
    private Teacher teacher;
    private String passwordagain;
    private ArrayList<Lesson> lessons;
    private String listoflessons;


    public Student(String name, String mail,
                   String password, String passwordagain) {
        super(name, mail, password, passwordagain , false);
        this.testpnimi = 0;
        this.numlessons = 0;
        this.numtests = 0;
        this.lessons= new ArrayList<>();


    }

    public int getTestpnimi() {
        return testpnimi;
    }

    public void setTestpnimi(int testpnimi) {
        this.testpnimi = testpnimi;
    }

    public int getNumlessons() {
        return numlessons;
    }

    public void setNumlessons(int numlessons) {
        this.numlessons = numlessons;
    }

    public int getNumtests() {
        return numtests;
    }

    public void setNumtests(int numtests) {
        this.numtests = numtests;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
       // teacher = t;
    }
    public void setLessonslist(){

}
}
