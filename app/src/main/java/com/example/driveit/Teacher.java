package com.example.driveit;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Teacher extends Person
{
    private ArrayList<Student> students;
    private String school;
    private String studyarea;
    private String lessontipe;
    private String lessonlength;
    private int lessonprice;

    public Teacher(String name, String mail, String password, String passwordagain) {
        super(name, mail, password, passwordagain, true);
        students=new ArrayList<Student>();
        this.school = school;
        this.studyarea= studyarea;
        this.lessontipe = lessontipe;
        this.lessonlength = lessonlength;
        this.lessonprice = lessonprice;
    }



    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getLessonlength() {
        return lessonlength;
    }

    public void setLessonlength(int lessonlength) {
        this.lessonlength = lessonlength;
    }

    public int getSwaitingtest() {
        return Swaitingtest;
    }

    public void setSwaitingtest(int swaitingtest) {
        Swaitingtest = swaitingtest;
    }

    public int getFreelessons() {
        return freelessons;
    }

    public void setFreelessons(int freelessons) {
        this.freelessons = freelessons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
