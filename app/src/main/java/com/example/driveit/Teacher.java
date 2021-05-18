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
    private int lessonlength;
    private int Swaitingtest;
    private int freelessons;
    private String status;
    private Map<Date, String> schedule;

    public Teacher(String name, String id, String phonenum, String mail, String studyarea, String school, String city, String lisensetype, String username, String password) {
        super(name, id, phonenum, mail, studyarea, school, city, lisensetype, username, password);
        students=new ArrayList<Student>();
        this.lessonlength = lessonlength;
        this.Swaitingtest = Swaitingtest;
        this.freelessons = freelessons;
        this.status = status;
        schedule= new HashMap<Date, String>();
    }
    public void initSchedule(){
        Calendar calendar= Calendar.getInstance();

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
