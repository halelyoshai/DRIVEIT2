package com.example.driveit;

import java.util.ArrayList;

public class Teacher extends Person
{
    private ArrayList<Student> students;
    private String lessonlength;
    private String Swaitingtest;
    private String freelessons;
    private String status;


    public Teacher(String name, String id, String phonenum, String mail, String studyarea, String school, String city, String lisensetype, String username, String password, ArrayList<Student> students, String lessonlength, String swaitingtest, String freelessons, String status) {
        super(name, id, phonenum, mail, studyarea, school, city, lisensetype, username, password);
        students=new ArrayList<Student>();
        this.lessonlength = lessonlength;
        this.Swaitingtest = swaitingtest;
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

    public String getSwaitingtest() {
        return Swaitingtest;
    }

    public void setSwaitingtest(String swaitingtest) {
        Swaitingtest = swaitingtest;
    }

    public String getFreelessons() {
        return freelessons;
    }

    public void setFreelessons(String freelessons) {
        this.freelessons = freelessons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
