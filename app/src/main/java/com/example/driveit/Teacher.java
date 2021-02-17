package com.example.driveit;

import java.util.ArrayList;

public class Teacher extends Person
{
    private ArrayList<Student> students;
    private String lessonlength;
    private int Swaitingtest;
    private int freelessons;
    private String status;


    public Teacher(String name, String id, String phonenum, String mail, String studyarea, String school, String city, String lisensetype, String username, String password) {
        super(name, id, phonenum, mail, studyarea, school, city, lisensetype, username, password);
        students=new ArrayList<Student>();
        this.lessonlength = lessonlength;
        this.Swaitingtest = Swaitingtest;
        this.freelessons = freelessons;
        this.status = status;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getLessonlength() {
        return lessonlength;
    }

    public void setLessonlength(String lessonlength) {
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
